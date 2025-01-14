package br.com.nahtanm.implementacao;

import br.com.nahtanm.dominio.Produto;
import br.com.nahtanm.interfaces.IProdutoDao;

public class ProdutoMapDao extends GenericoMapDao<Produto> implements IProdutoDao {

    public ProdutoMapDao() {
        super();
    }

    @Override
    public Class<Produto> getClassNome() {
        return Produto.class;
    }
}
