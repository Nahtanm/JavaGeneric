package br.com.nahtanm;

import br.com.nahtanm.dominio.Cliente;
import br.com.nahtanm.dominio.Produto;
import br.com.nahtanm.implementacao.ClienteMapDao;
import br.com.nahtanm.implementacao.ProdutoMapDao;
import br.com.nahtanm.interfaces.IClienteDao;
import br.com.nahtanm.interfaces.IProdutoDao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private IClienteDao iClienteDao;
    private IProdutoDao iProdutoDao;

    public App() {
        this.iClienteDao = new ClienteMapDao();
        this.iProdutoDao = new ProdutoMapDao();
        appPrincipal();
    }

    public void appPrincipal() {
        JOptionPane.showMessageDialog(null, "Bem Vindo ao nosso aplicativo.", "Bem vindo.", JOptionPane.INFORMATION_MESSAGE);

        String opcao = "0";
        String opcaoClienteProduto;
        while (opcao != "5") {
            opcao = JOptionPane.showInputDialog(null,
                    "1 - Cadastrar.  2 - Consultar. " +
                            "\n3 - Exclusão.  4 - Alterar. " +
                            "\n5 - Sair.",
                    "TELA INICIAL."
                    , JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) {
                case "1":
                    opcaoClienteProduto = JOptionPane.showInputDialog(null,
                            "Deseja cadastra um cliente ou um produto? \n[1] - Cliente.\n[2] - Produto.",
                            "Cadastro."
                            , JOptionPane.INFORMATION_MESSAGE);
                    cadastrar(opcaoClienteProduto);
                    break;
                case "2":
                    opcaoClienteProduto = JOptionPane.showInputDialog(null,
                            "Deseja consultar um cliente ou um produto? \n[1] - Cliente.\n[2] - Produto.",
                            "Consulta."
                            , JOptionPane.INFORMATION_MESSAGE);
                    consultar(opcaoClienteProduto);
                    break;
                case "3":
                    opcaoClienteProduto = JOptionPane.showInputDialog(null,
                            "Deseja excluir um cliente ou um produto? \n[1] - Cliente.\n[2] - Produto.",
                            "Consulta."
                            , JOptionPane.INFORMATION_MESSAGE);
                    excluir(opcaoClienteProduto);
                    break;
                case "4":
                    opcaoClienteProduto = JOptionPane.showInputDialog(null,
                            "Deseja alterar um cliente ou um produto? \n[1] - Cliente.\n[2] - Produto.",
                            "Consulta."
                            , JOptionPane.INFORMATION_MESSAGE);
                    alterar(opcaoClienteProduto);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso app.", "", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(1);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.", "Bem vindo.", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void alterar(String opcaoClienteProduto) {
        String variavel = JOptionPane.showInputDialog(null, "Informe o codigo.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
        Long codigo = Long.valueOf(variavel);

        if (opcaoClienteProduto.equals("1")) {
            Cliente cliente = alterarCliente();
            this.iClienteDao.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Cadastro alterado.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);

        } else if (opcaoClienteProduto.equals("2")) {
            Produto produto = alterarProduto();
            this.iProdutoDao.alterar(produto);
            JOptionPane.showMessageDialog(null, "Cadastrro alterado.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private Produto alterarProduto() {
        String variavel = JOptionPane.showInputDialog(null, "Informe nome e codigo separado por ','.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
        String[] variavelSeparada = variavel.split(",");
        Produto produto = new Produto(variavelSeparada[0], variavelSeparada[1]);
        return produto;
    }

    private void excluir(String opcaoClienteProduto) {
        String variavel = JOptionPane.showInputDialog(null, "Informe o codigo.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
        Long codigo = Long.valueOf(variavel);

        if (opcaoClienteProduto.equals("1")) {
            Cliente cliente = this.iClienteDao.consultar(codigo);
            this.iClienteDao.excluir(cliente.getCodigo());
            JOptionPane.showMessageDialog(null, "Cliente exluido.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
        } else if (opcaoClienteProduto.equals("2")) {
            Produto produto = this.iProdutoDao.consultar(codigo);
            this.iProdutoDao.excluir(produto.getCodigo());
            JOptionPane.showMessageDialog(null, "Produto excluido", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cadastrar(String opcao) {

        if (opcao.equals("1")) {

            Cliente cliente = alterarCliente();

            if (!this.iClienteDao.cadastrar(cliente)) {
                JOptionPane.showMessageDialog(null, "Cadastro já existente.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (opcao.equals("2")) {
            Produto produto = alterarProduto();

            if (!this.iProdutoDao.cadastrar(produto)) {
                JOptionPane.showMessageDialog(null, "Cadastro já existente.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void consultar(String opcao) {
        String variavel = JOptionPane.showInputDialog(null, "Informe o codigo.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
        Long codigo = Long.valueOf(variavel);
        if (opcao.equals("1")) {
            Cliente cliente = this.iClienteDao.consultar(codigo);
            if (cliente != null){
                JOptionPane.showMessageDialog(null, cliente, "Consulta.", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (opcao.equals("2")) {
            Produto produto = this.iProdutoDao.consultar(codigo);
            if (produto != null){
                JOptionPane.showMessageDialog(null, produto, "Consulta.", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Consulta.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public Cliente alterarCliente() {
        String[] listaCadastroCliente = {"Nome", "CPF", "Cidade", "Estado", "Numero"};
        List<String> listaCliente = new ArrayList<>();
        int i = 0;
        while (i < 5) {
            String variavel = JOptionPane.showInputDialog(null, "Informe " + listaCadastroCliente[i], "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            if (variavel != null) {
                listaCliente.add(variavel);
                i++;
            } else {
                JOptionPane.showMessageDialog(null, "Campo vázio.", "Cadastro.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        Cliente cliente = new Cliente(listaCliente.get(0), listaCliente.get(1), listaCliente.get(2), listaCliente.get(3), listaCliente.get(4));

        return cliente;
    }

}
