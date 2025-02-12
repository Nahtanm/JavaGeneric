package br.com.nahtanm.implementacao;

import br.com.nahtanm.dominio.Cliente;
import br.com.nahtanm.interfaces.IClienteDao;

public class ClienteMapDao extends GenericoMapDao<Cliente> implements IClienteDao {

    public ClienteMapDao() {
        super();
    }

    @Override
    public Class<Cliente> getClassNome() {
        return Cliente.class;
    }

    @Override
    public void atualizarCadastro(Cliente entidadeAtualizada, Cliente entidadeAntiga) {
        entidadeAntiga.setNome(entidadeAtualizada.getNome());
        entidadeAntiga.setCidade(entidadeAtualizada.getCidade());
        entidadeAntiga.setEstado(entidadeAtualizada.getEstado());
        entidadeAntiga.setNumero(entidadeAtualizada.getNumero());
    }
}
