package br.com.nahtanm.interfaces.generico;

import java.util.Collection;

public interface IGenericoDao<T extends Observador>{
    public Boolean cadastrar(T entidade);
    public void alterar(T entidade);
    public void excluir(Long codigo);
    public T consultar(Long codigo);
    public Collection<T> consultarTodos();
}
