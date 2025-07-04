package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AcessoHistoricoService {
    Scanner leia = new Scanner(System.in);
    public static String  testandoValorCelular = "";


    public String menuCelular() throws SQLException {
   String teste = RespostaApiEnum.MENSAGEM_HIST.getDescricao();
//        int valorSelecionado = leia.nextInt();

        String opcaoDeAcesso = "";

        switch (testandoValorCelular) {
            case "1":
                opcaoDeAcesso = liberar();
                break;
            case "2":
                opcaoDeAcesso = String.valueOf(historicoHoje());
                break;
            case "3":
                opcaoDeAcesso = String.valueOf(historicoMesAnterior());

            default:
                System.out.println("Escolha uma opção valida!");
        }
        return opcaoDeAcesso;
    }


    public Object historicoHojeCompleto() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT * FROM MORADORES.HISTORICO h WHERE h.`DATA` = curdate() ORDER BY hora asc;";
        conexao.prepareStatement(sql);

        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaHoje = new ArrayList<>();
        String teste = "Data   |   Hora   | Parentesco   |     Status   |\n";
        listaHoje.add(teste);
        while (rs.next()) {
            Date data = rs.getDate("DATA");
            String hora = rs.getString("HORA");
            String nome = rs.getString("NOME");
            String sobrenome = rs.getString("NOME_DO_MEIO");
            String ultimoNome = rs.getString("ULTIMO_NOME");
            String parentesco = rs.getString("PARENTESCO");
            String status = rs.getString("STATUS");

            registro = data + " | " + hora + " | " + nome + " " + sobrenome + " "+
                    ultimoNome + " | " + parentesco + " |" + status + " |\n";
            listaHoje.add(registro);
        }

        return listaHoje;
    }
    public Object historicoHoje() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT  * FROM MORADORES.HISTORICO h WHERE h.`DATA` = curdate() ORDER BY hora asc;";
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
        String sql = "SELECT *  FROM MORADORES.HISTORICO h WHERE `DATA` >= DATE_SUB(curdate(),INTERVAL 2 MONTH) AND h.`DATA` <= curdate() ORDER BY  DATA, HORA ASC;";

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
    public Object historicoMesAnteriorCompleto() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT *  FROM MORADORES.HISTORICO h WHERE `DATA` >= DATE_SUB(curdate(),INTERVAL 2 MONTH) AND h.`DATA` <= curdate() ORDER BY  DATA, HORA ASC;";
        conexao.prepareStatement(sql);

        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaMesAnterior = new ArrayList<>();
        String teste = "Data   |   Hora   | Parentesco   |     Status   |\n";
        listaMesAnterior.add(teste);
        while (rs.next()) {
            Date data = rs.getDate("DATA");
            String hora = rs.getString("HORA");
            String nome = rs.getString("NOME");
            String sobrenome = rs.getString("NOME_DO_MEIO");
            String ultimoNome = rs.getString("ULTIMO_NOME");
            String parentesco = rs.getString("PARENTESCO");
            String status = rs.getString("STATUS");

            registro = data + " | " + hora + " | " + nome + " " + sobrenome + " "+
                    ultimoNome + " | " + parentesco + " |" + status + " |\n";
            listaMesAnterior.add(registro);
        }

        return listaMesAnterior;
    }

    private String liberar() throws SQLException {
        String liberado = "Liberado pelo admin";
        return liberado;
    }
}
