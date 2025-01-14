import br.com.nahtanm.App;
import br.com.nahtanm.dominio.Cliente;
import br.com.nahtanm.dominio.Produto;
import br.com.nahtanm.implementacao.ClienteMapDao;
import br.com.nahtanm.implementacao.ProdutoMapDao;
import br.com.nahtanm.interfaces.IClienteDao;
import br.com.nahtanm.interfaces.IProdutoDao;
import br.com.nahtanm.interfaces.generico.IGenericoDao;

public class Main {
    public static void main(String[] args) {
        //Aplicação principal //
        App app = new App();

        ////////////////////////////Teste para a execução//////////////////////////////////////////////

        // Parte do Cliente /////////////////////////////////////////////////////////////////////////////

      /*  Cliente cliente1 = new Cliente("Nahtanm", "12", "BG", "PI", "21");
        Cliente cliente2 = new Cliente("Isabella", "23", "THE", "PI", "32");
        Cliente cliente3 = new Cliente("Jacilene", "34", "BG", "PI", "43");
        Cliente cliente4 = new Cliente("Durval", "45", "BG", "PI", "54");
        Cliente cliente5 = new Cliente("Davi", "56", "FO", "PI", "65");*/

        /* Criando ClienteDoa */
        /*IClienteDao clienteMapDao = new ClienteMapDao();*/

        /* Cadastrando clientes */
       /* clienteMapDao.cadastrar(cliente1);
        clienteMapDao.cadastrar(cliente2);
        clienteMapDao.cadastrar(cliente3);
        clienteMapDao.cadastrar(cliente4);
        clienteMapDao.cadastrar(cliente5);
        System.out.println("Cadastrando Cliente \n" + clienteMapDao.consultarTodos());
        System.out.println();*/

        /* Excluindo cadastro */
       /* clienteMapDao.excluir(cliente1.getCodigo());
        System.out.println("Excluindo Cliente \n" + clienteMapDao.consultarTodos());
        System.out.println();*/

        /* Atualizar cliente */
       /* Cliente novoCliente =  new Cliente("Ravi","56","RG","PI","10");
        clienteMapDao.alterar(novoCliente);
        System.out.println("Atualizando Cliente\n" + clienteMapDao.consultarTodos());
        System.out.println();*/

        // Parte do Produto /////////////////////////////////////////////////////////////////////////////

        /*Produto produto1 = new Produto("Arroz", "98");
        Produto produto2 = new Produto("Feijão", "87");
        Produto produto3 = new Produto("Carne", "76");
        Produto produto4 = new Produto("Batata", "65");
        Produto produto5 = new Produto("Macarrão", "54");*/

        /* Criando ProdutoDoa*/
        /* IProdutoDao iProdutoDao = new ProdutoMapDao();
         */
        /* Cadastrando produto */
       /* iProdutoDao.cadastrar(produto1);
        iProdutoDao.cadastrar(produto2);
        iProdutoDao.cadastrar(produto3);
        iProdutoDao.cadastrar(produto4);
        iProdutoDao.cadastrar(produto5);
        System.out.println("Cadastrando Produto\n" + iProdutoDao.consultarTodos());
        System.out.println();
        */
        /* Excluindo cadastro de produto */
        /*iProdutoDao.excluir(produto1.getCodigo());
        System.out.println("Excluindo Produto\n" + iProdutoDao.consultarTodos());
        System.out.println();*/

        /* Atualizando produto*/
        /*Produto novoProduto = new Produto("Potato", "65");
        iProdutoDao.alterar(novoProduto);
        System.out.println("Atualizando Produto\n" + iProdutoDao.consultarTodos());
        System.out.println();*/

    }
}