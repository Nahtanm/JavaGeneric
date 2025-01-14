package br.com.nahtanm.implementacao;

import br.com.nahtanm.interfaces.generico.IGenericoDao;
import br.com.nahtanm.interfaces.generico.Observador;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericoMapDao<T extends Observador> implements IGenericoDao<T> {
    private Map<Class, Map<Long, T>> mapaExterno;
    private Map<Long, T> mapaInterno;

    public GenericoMapDao() {
        if (this.mapaExterno == null) {
            this.mapaExterno = new HashMap<>();
            this.mapaInterno = this.mapaExterno.get(getClassNome());
            if (this.mapaInterno == null) {
                this.mapaInterno = new HashMap<>();
                this.mapaExterno.put(getClassNome(), this.mapaInterno);
            }
        }
    }

    public abstract Class<T> getClassNome();

    @Override
    public Boolean cadastrar(T entidade) {
        this.mapaInterno = this.mapaExterno.get(getClassNome());
        if (this.mapaInterno.containsKey(entidade.getCodigo())){
            System.out.println("Já cadastrado");
            return false;
        }
        this.mapaInterno.put(entidade.getCodigo(), entidade);
        this.mapaExterno.put(getClassNome(),this.mapaInterno);
        return true;
    }

    @Override
    public void alterar(T entidade) {

    }

    @Override
    public void excluir(Long codigo) {

    }

    @Override
    public T consultar(Long codigo) {
        return this.mapaInterno.get(codigo);
    }

    @Override
    public Collection<T> consultarTodos() {
        return this.mapaInterno.values() ;
    }
}
