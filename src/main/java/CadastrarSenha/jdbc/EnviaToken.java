package CadastrarSenha.jdbc;

import CadastrarSenha.BootTelegramApi.TokenUsuario;
import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.Util.Variavel.ValoresDigitados;

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

    ValoresDigitados valoresDigitados = new ValoresDigitados();
    String valorToken = chaveToken.getPegaToken();


    public String enviaToken() throws SQLException {

        TokenUsuario tokenUsuario = new TokenUsuario();
        ChaveToken chaveToken = new ChaveToken();

        Connection conexao = CriarTabelaPessoa.getConnection();
        String valorToken = "INSERT INTO tokens (token) VALUES(?)";

        PreparedStatement statement = conexao.prepareStatement(valorToken);
        statement.setString(1, (this.valorToken));

        statement.execute();

        List<String> lista = new ArrayList<>();
        lista.add(this.valorToken);
        for (String listaToken : lista) {
            tokenSalvo = listaToken;
            valoresDigitados.setValorTokenDigitado(tokenSalvo);
        }

        System.out.println("Numero incluido com sucesso ...");
        return tokenSalvo;
    }

    public ChaveToken getChaveToken() {
        return chaveToken;
    }

    public String getValorToken() {
        return valorToken;
    }

    public String consultaQuery() throws SQLException {

        String numeroToken = "";
        Connection conexao = CriarTabelaPessoa.getConnection();
        String sql = "select * from tokens order by id desc limit 1";

        List<String> lista = new ArrayList<>();

        Statement statement = conexao.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> token = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String codigo = resultSet.getString("token");
             String.valueOf(token.addAll(Collections.singleton(codigo)));
            numeroToken = codigo;
            valoresDigitados.setValorTokenAdquidiro(codigo);
        }

//     TODO     NÃO APAGAR PODE SER UTIL

        int valorId = 1;
        System.out.println("Id   token ");
        for (String valorToken : token)
            System.out.println("" + valorId++ + "  |  " + valorToken);
        valoresDigitados.setValorTokenAdquidiro(valorToken);
        return numeroToken;
    }

    public static void main(String[] args) throws SQLException {
        EnviaToken token = new EnviaToken();
        token.consultaQuery();
    }
}