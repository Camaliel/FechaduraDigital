package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncluiToken {


    public String incluiToken() throws SQLException {
        ChaveToken chaveToken = new ChaveToken();

        String tokenIncluido = "Numero enviado ==> " + chaveToken.getPegaRoleta();
        Connection conexao = CriarConexao.getConnetion();
        String incluiNumeroToken = "INSERT INTO numero_verificacao (campo) VALUES (?)";
        System.out.println("INCLUIDO NO MYSQL ...");

        PreparedStatement stmnt = conexao.prepareStatement(incluiNumeroToken);
        stmnt.setString(1, chaveToken.getPegaRoleta());

        stmnt.execute();
        conexao.close();

        return tokenIncluido;
    }
}
