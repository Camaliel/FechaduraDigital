package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveTokenService;
import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncluiToken {

    public String getGuardaToken() {
        return guardaToken;
    }

    public void setGuardaToken(String guardaToken) {
        this.guardaToken = guardaToken;
    }

    public String guardaToken = "";

    public String incluiToken() throws SQLException {
        ChaveTokenService chaveTokenService = new ChaveTokenService();

        Connection conexao = CriarConexao.getConnetion();
        String tokenTela = chaveTokenService.getPegaRoleta();
        String incluiNumeroToken = "INSERT INTO administrador.tokens (token) VALUES (?)";


        PreparedStatement stmnt = conexao.prepareStatement(incluiNumeroToken);
        stmnt.setString(1, chaveTokenService.getPegaRoleta());

        stmnt.execute();
        conexao.close();

        return tokenTela;
    }
}