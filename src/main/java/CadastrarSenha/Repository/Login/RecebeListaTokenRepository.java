package CadastrarSenha.Repository.Login;

import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecebeListaTokenRepository {
    public List<String> recebeListaToken() throws SQLException {

        Connection connection = CriarConexao.getConnetion();

        String sqlRecebeLista = "SELECT * FROM MORADORES.TOKENS t ";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlRecebeLista);

        List<String>recebendoLista = new ArrayList<>();
        while (rs.next()){
         String tokenLista =  rs.getString("TOKEN");
            recebendoLista.add(tokenLista);

        }

        return recebendoLista;
    }

    public static void main(String[] args) throws SQLException {
        RecebeListaTokenRepository repository = new RecebeListaTokenRepository();
        System.out.println(repository.recebeListaToken());
    }
}
