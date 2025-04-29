package CadastrarSenha.Repository;

import CadastrarSenha.Service.GeradorDeChaveTokenService;
import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncluiTokenRepository {

    public String incluiTokenAdministracao() throws SQLException {
        GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();

        Connection conexao = CriarConexao.getConnetion();
        String tokenTela = geradorDeChaveTokenService.getPegaRoleta();
        String incluiNumeroToken = "INSERT INTO ADMINISTRADOR.TOKENS (TOKEN) VALUES (?)";


        PreparedStatement stmnt = conexao.prepareStatement(incluiNumeroToken);
        stmnt.setString(1, tokenTela);

        stmnt.execute();
        conexao.close();

        return tokenTela;
    }

    GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();


    public void setValorToken(String valorToken) {
        this.valorToken = valorToken;
    }

    String valorToken = geradorDeChaveTokenService.getPegaToken();


    public String enviaToken() throws SQLException {
        String tokenSalvo = "";

        Connection conexao = CriarConexao.getConnetion();
        String valorToken = "INSERT INTO MORADORES.TOKENS (TOKEN) VALUES(?)";
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