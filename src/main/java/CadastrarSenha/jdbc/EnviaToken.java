package CadastrarSenha.jdbc;

import CadastrarSenha.BootTelegramApi.TokenUsuario;
import CadastrarSenha.Service.ChaveToken;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviaToken {

    public String getTokenSalvo() {
        return tokenSalvo;
    }

    String tokenSalvo = "";
    ChaveToken chaveToken = new ChaveToken();
    String teste = chaveToken.getPegaToken();


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
        for (String listaToken : lista) {
            tokenSalvo = listaToken;
        }

        System.out.println("Numero incluido com sucesso ...");
        return tokenSalvo;
    }

    public void consultaQuery() throws SQLException {
        Connection conexao = CriarTabelaPessoa.getConnection();
        String sql = "select * from numero_verificacao order by id desc limit 1";

        List<String> lista = new ArrayList<>();

        Statement statement = conexao.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> token = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String codigo = resultSet.getString("campo");
            token.addAll(Collections.singleton(codigo));
        }

        int codigo = 1;
        System.out.println("Id   campo ");
        for (String teste : token)
            System.out.println("" + codigo++ + "  |  " + teste);

    }

    public static void main(String[] args) throws SQLException {
        EnviaToken token = new EnviaToken();
        token.consultaQuery();
    }
}