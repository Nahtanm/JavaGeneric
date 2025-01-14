import br.com.nahtanm.dominio.Cliente;
import br.com.nahtanm.dominio.Produto;
import br.com.nahtanm.implementacao.ClienteMapDao;
import br.com.nahtanm.implementacao.ProdutoMapDao;
import br.com.nahtanm.interfaces.IClienteDao;
import br.com.nahtanm.interfaces.IProdutoDao;
import br.com.nahtanm.interfaces.generico.IGenericoDao;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Nahtanm", "12", "BG", "PI","21");
        Cliente cliente2 = new Cliente("Isabella", "23", "THE", "PI","32");
        Cliente cliente3 = new Cliente("Jacilene", "34", "BG", "PI","43");
        Cliente cliente4 = new Cliente("Durval", "45", "BG", "PI","54");
        Cliente cliente5 = new Cliente("Davi", "56", "FO", "PI","65");

        IClienteDao clienteMapDao = new ClienteMapDao();

        clienteMapDao.cadastrar(cliente1);
        clienteMapDao.cadastrar(cliente2);
        clienteMapDao.cadastrar(cliente3);
        clienteMapDao.cadastrar(cliente4);
        clienteMapDao.cadastrar(cliente5);

        System.out.println(clienteMapDao.consultarTodos());

        Produto produto1 = new Produto("Arroz", "98");
        Produto produto2 = new Produto("Feijão", "87");
        Produto produto3 = new Produto("Carne", "76");
        Produto produto4 = new Produto("Batata", "65");
        Produto produto5 = new Produto("Macarrão", "54");

        IProdutoDao iProdutoDao = new ProdutoMapDao();

        iProdutoDao.cadastrar(produto1);
        iProdutoDao.cadastrar(produto2);
        iProdutoDao.cadastrar(produto3);
        iProdutoDao.cadastrar(produto4);
        iProdutoDao.cadastrar(produto5);

        System.out.println(iProdutoDao.consultarTodos());

    }
}