package CadastrarSenha.Service;

import CadastrarSenha.BootTelegramApi.Respostas;
import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Repository.HistoricoRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static CadastrarSenha.BootTelegramApi.Respostas.respostaTodos;
import static CadastrarSenha.BootTelegramApi.Respostas.tokenDigitadoPeloUsuario;

public class BlackListService {

    public Object bloquearUsuario() throws SQLException {
        String registro = "";
        String numeroBloqueado = "";
        int contador = 0;

        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT token, nome  FROM MORADORES.HISTORICO;";

        conexao.prepareStatement(sql);
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaMesAnterior = new ArrayList<>();
        String cabecalho = "Tokens | Nomes" + "\n";
        listaMesAnterior.add(cabecalho);
        while (rs.next()) {
            contador++;
            String tokenLista = rs.getString("TOKEN");
            String nomeLista = rs.getString("NOME");
            registro = "[ "+ contador + " ] -" + tokenLista + " " + nomeLista + "\n";

            listaMesAnterior.add(registro);
            if (tokenDigitadoPeloUsuario.equals(tokenLista)) {
                numeroBloqueado = " \n" + "Numero bloqueado com sucesso [SIMULAÇÃO] " + tokenLista;
                break;
            } else if (respostaTodos) {
                numeroBloqueado = " \n" + "Numeros listados para bloqueio";
                respostaTodos = false;

            } else {
                numeroBloqueado = "\n" + "Nenhum numero bloqueado " + "\n" +
                        "Para bloquear, basta digitas [Bloquear + token]";
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