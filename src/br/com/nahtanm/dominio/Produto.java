package br.com.nahtanm.dominio;

import br.com.nahtanm.interfaces.generico.Observador;

import java.util.Objects;

public class Produto implements Observador {
    private String nome;
    private Long codigo;

    public Produto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = Long.valueOf(codigo);
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "\nPRODUTO{ " +
                "NOME='" + nome + '\'' +
                ", CODIGO=" + codigo + "}";

    }
}
