package br.com.nahtanm.dominio;

import br.com.nahtanm.interfaces.generico.Observador;

import java.util.Objects;

public class Cliente implements Observador {
    private String nome;
    private Long cpf;
    private String cidade;
    private String estado;
    private String numero;

    public Cliente(String nome, String cpf, String cidade, String estado, String numero) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf);
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "\nCLIENTE{ " + "NOME='" + nome + '\'' + ", CPF=" + cpf +
                ", CIDADE='" + cidade + '\'' +
                ", ESTADO='" + estado + '\'' +
                ", NUMERO='" + numero + '\'' + "}";
    }

    @Override
    public Long getCodigo() {
        return this.cpf;
    }
}
