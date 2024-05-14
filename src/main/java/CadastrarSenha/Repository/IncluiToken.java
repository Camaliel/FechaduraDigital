package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncluiToken {

    public String incluiToken() throws SQLException, ClassNotFoundException {
        ChaveToken chaveToken = new ChaveToken();
        ConfereChaveToken confereChaveToken = new ConfereChaveToken();

        Connection conexao = CriarConexao.getConnetion();
        String excluiToken = " DELETE FROM tokens";
        String tokenTela = "Numero enviado ==> " + chaveToken.getPegaRoleta();
        String incluiNumeroToken = "INSERT INTO tokens (token) VALUES (?)";

        PreparedStatement stmnt = conexao.prepareStatement(incluiNumeroToken);
        stmnt.setString(1, excluiToken);
        stmnt.setString(1, chaveToken.getPegaRoleta());

        stmnt.execute();
        conexao.close();

        return tokenTela;
    }
}