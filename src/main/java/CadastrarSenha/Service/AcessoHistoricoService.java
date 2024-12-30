package CadastrarSenha.Service;

import CadastrarSenha.Repository.HistoricoRepository;
import CadastrarSenha.jdbc.CriarConexao;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AcessoHistoricoService {
    Scanner leia = new Scanner(System.in);
    HistoricoRepository repository = new HistoricoRepository();
    Conexao conexao = new Conexao();

    public String menuCelular() throws SQLException {
        System.out.println("Selecione uma opção | 1 Liberar | 2 Historico [Constr] | Denunciar [Constr] | ");
        int valorSelecionado = leia.nextInt();

        String opcaoDeAcesso = "";

        switch (valorSelecionado) {
            case 1:
                opcaoDeAcesso = liberar();
                break;
            case 2:
                opcaoDeAcesso = String.valueOf(historicoHoje());
                break;
            case 3:
                opcaoDeAcesso = String.valueOf(historicoMesAnterior());

            default:
                System.out.println("Escolha uma opção valida!");
        }
        return opcaoDeAcesso;
    }


    private Object historicoHoje() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT  * FROM historico h WHERE h.`DATA` = curdate()";
        conexao.prepareStatement(sql);

        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaHoje = new ArrayList<>();
        String teste = "Data   |   Hora   | Parentesco   |     Status   |\n";
        listaHoje.add(teste);
        while (rs.next()) {
            Date data = rs.getDate("DATA");
            String hora = rs.getString("HORA");
            String parentesco = rs.getString("PARENTESCO");
            String status = rs.getString("STATUS");

            registro = data + " | " + hora + " | " + parentesco + " | " + status + " |\n";
            listaHoje.add(registro);
        }

        return listaHoje;
    }
    public Object historicoMesAnterior() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT *  FROM historico h WHERE `DATA` >= DATE_SUB(curdate(),INTERVAL 2 MONTH) AND h.`DATA` < curdate()";
        conexao.prepareStatement(sql);

        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaMesAnterior = new ArrayList<>();
        String teste = "Data   |   Hora   | Parentesco   |     Status   |\n";
        listaMesAnterior.add(teste);
        while (rs.next()) {
            Date data = rs.getDate("DATA");
            String hora = rs.getString("HORA");
            String parentesco = rs.getString("PARENTESCO");
            String status = rs.getString("STATUS");

            registro = data + " | " + hora + " | " + parentesco + " | " + status + " |\n";
            listaMesAnterior.add(registro);
        }

        return listaMesAnterior;
    }


    private String liberar() {
        String liberado = "Liberado pelo admin";
        repository.enviaHistorico("Adm", "Liberado");
        return liberado;
    }

    public static void main(String[] args) throws SQLException {
        AcessoHistoricoService service = new AcessoHistoricoService();
        System.out.println(service.menuCelular());
    }
}
