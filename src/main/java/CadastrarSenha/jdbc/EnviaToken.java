package CadastrarSenha.jdbc;

import CadastrarSenha.BootTelegramApi.Respostas;
import CadastrarSenha.BootTelegramApi.TokenUsuario;
import CadastrarSenha.jdbc.Entity.ChaveToken;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnviaToken {

    public String getTokenSalvo() {
        return tokenSalvo;
    }

    String tokenSalvo = "";
    ChaveToken chaveToken = new ChaveToken();
    String teste = chaveToken.getTesteRoleta();


    public String enviaToken() throws SQLException {

        TokenUsuario tokenUsuario = new TokenUsuario();
        ChaveToken chaveToken = new ChaveToken();

        Connection conexao = CriarTabelaPessoa.getConnection();
        String numeroVerificacao = "INSERT INTO numero_verificacao (campo) VALUES(?)";

        PreparedStatement statement = conexao.prepareStatement(numeroVerificacao);
        statement.setString(1, (teste));

        statement.execute();

        List<String> lista = new ArrayList<>();
        lista.add(teste);
        for (String listaToken:lista) {
            tokenSalvo = listaToken;
        }

        System.out.println("Numero incluido com sucesso ...");

        return tokenSalvo;
    }

    public static void main(String[] args) throws SQLException {
        EnviaToken token = new EnviaToken();
        token.enviaToken();
        token.getTokenSalvo();
        System.out.println(token.getTokenSalvo());
    }
}