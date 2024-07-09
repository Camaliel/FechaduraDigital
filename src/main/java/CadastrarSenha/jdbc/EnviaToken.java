package CadastrarSenha.jdbc;

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

    public ChaveToken getChaveToken() {
        return chaveToken;
    }

    public String getValorToken() {
        return valorToken;
    }

    public String consultaQuery() throws SQLException, ClassNotFoundException {

        String numeroToken = "";
        Connection conexao = CriarConexao.getConnetion();
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
        }

//     TODO     NÃO APAGAR PODE SER UTIL [LEMBRETE]

//        int valorId = 1;
//        System.out.println("Id   token ");
//        for (String valorToken : token)
//            System.out.println("" + valorId++ + "  |  " + valorToken);
//        valoresDigitados.setValorTokenAdquidiro(valorToken);
        return numeroToken;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EnviaToken token = new EnviaToken();
        token.consultaQuery();
    }
}