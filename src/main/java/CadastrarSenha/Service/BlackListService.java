package CadastrarSenha.Service;

import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Repository.HistoricoRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static CadastrarSenha.BootTelegramApi.Respostas.tokenDigitadoPeloUsuario;

public class BlackListService {

    public static String testandoValor = "";

    Conexao DAO = new Conexao();
    HistoricoRepository repository = new HistoricoRepository();

    public Object bloquearUsuario() throws SQLException {
        String registro = "";
        String numeroBloqueado = "";

        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT token, nome  FROM MORADORES.HISTORICO;";

        conexao.prepareStatement(sql);
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaMesAnterior = new ArrayList<>();
        String cabecalho = "Tokens | Nomes" + "\n";
        listaMesAnterior.add(cabecalho);
        while (rs.next()) {

            String tokenLista = rs.getString("TOKEN");
            String nomeLista = rs.getString("NOME");
            registro = tokenLista + " " + nomeLista + "\n";

            listaMesAnterior.add(registro);


            if (tokenDigitadoPeloUsuario.equals(tokenLista)) {
                numeroBloqueado = " \n" + "Numero bloqueado com sucesso [SIMULAÇÃO]";
                break;
            } else if (tokenDigitadoPeloUsuario.isEmpty()) {
                numeroBloqueado = "\n" + "Numero token vazio";
                break;  
            } else {
                numeroBloqueado = "\n" + "Nenhum numero bloqueado";
            }

        }

        listaMesAnterior.add(numeroBloqueado);
        return listaMesAnterior;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        BlackListService service = new BlackListService();
        System.out.println(service.bloquearUsuario());
////        service.removeDaListaNegra();
    }
}