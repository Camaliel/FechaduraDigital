package CadastrarSenha.jdbc;

import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.Util.Variavel.ValoresDigitados;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviaToken {

    String tokenSalvo = "";
    ChaveToken chaveToken = new ChaveToken();

    ValoresDigitados valoresDigitados = new ValoresDigitados();

    public void setValorToken(String valorToken) {
        this.valorToken = valorToken;
    }

    String valorToken = chaveToken.getPegaToken();


    public String enviaToken() throws SQLException {

        ChaveToken chaveToken = new ChaveToken();

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

    public String consultaQuery() throws SQLException, ClassNotFoundException {

        String numeroToken = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "select * from administrador.tokens order by id desc limit 1";

        Statement statement = conexao.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> token = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String codigo = resultSet.getString("token");
            String.valueOf(token.addAll(Collections.singleton(codigo)));
            numeroToken = codigo;
        }

        return numeroToken;
    }
}