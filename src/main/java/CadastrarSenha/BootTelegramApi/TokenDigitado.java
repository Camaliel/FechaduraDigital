package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TokenDigitado {
    Connection conexao = CriarConexao.getConnetion();
    static String insereValor = "";
    static String valorRetornadoComSucesso;

    public Object tokenDigitadoTelegram() throws SQLException {
        String registro = "";
        String tokenLista = "";

        String sql = "SELECT TOKEN FROM MORADORES.TOKENS;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaRetorno = new ArrayList<>();
        while (rs.next()) {
            tokenLista = rs.getString("TOKEN");

            registro = tokenLista;
            listaRetorno.add(registro);

        }

        if (insereValor.contains(registro)){
            valorRetornadoComSucesso = insereValor;
            return valorRetornadoComSucesso;
        }else {
            valorRetornadoComSucesso = "Token retornado invalido";
            return valorRetornadoComSucesso;
        }

        // PROCURAR UMA FORMA DE ARMAZENAR O VALOR QUE FOR DIGITADO NO TELEGRAM LER DOCUMENTAÇÃO

    }

// CRIAR OUTRO METODO SOMENTE PRA O CELULAR

    public static void main(String[] args) throws SQLException {
        TokenDigitado ts = new TokenDigitado();
        System.out.println(ts.tokenDigitadoTelegram());

    }
}