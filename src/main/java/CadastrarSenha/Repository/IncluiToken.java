package CadastrarSenha.Repository;

import CadastrarSenha.Service.GeradorDeChaveTokenService;
import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncluiToken {

    public String incluiTokenAdministracao() throws SQLException {
        GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();

        Connection conexao = CriarConexao.getConnetion();
        String tokenTela = geradorDeChaveTokenService.getPegaRoleta();
        String incluiNumeroToken = "INSERT INTO administrador.tokens (token) VALUES (?)";


        PreparedStatement stmnt = conexao.prepareStatement(incluiNumeroToken);
        stmnt.setString(1, geradorDeChaveTokenService.getPegaRoleta());

        stmnt.execute();
        conexao.close();

        return tokenTela;
    }
    String tokenSalvo = "";
    GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();


    public void setValorToken(String valorToken) {
        this.valorToken = valorToken;
    }

    String valorToken = geradorDeChaveTokenService.getPegaToken();


    public String enviaToken() throws SQLException {

        Connection conexao = CriarConexao.getConnetion();
        String valorToken = "INSERT INTO tokens (token) VALUES(?)";

        PreparedStatement statement = conexao.prepareStatement(valorToken);
        statement.setString(1, (this.valorToken));

        statement.execute();

        List<String> lista = new ArrayList<>();
        lista.add(this.valorToken);
        for (String listaToken : lista) {
            tokenSalvo = listaToken;
        }

        return tokenSalvo;
    }
}