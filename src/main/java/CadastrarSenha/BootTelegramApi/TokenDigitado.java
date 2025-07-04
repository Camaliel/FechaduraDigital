package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TokenDigitado {
    Connection conexao = CriarConexao.getConnetion();
    static String insereValor = "";
    public static String valorRetornadoComSucesso;

    public String tokenDigitadoTelegram() throws SQLException {
        String tokenLista;

        String sql = "SELECT TOKEN, CHEFE_FAMILIA FROM MORADORES.TOKENS where MORADORES.TOKENS.CHEFE_FAMILIA = 'S'";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaRetorno = new ArrayList<>();

        while (rs.next()) {
            tokenLista = rs.getString("TOKEN");
            listaRetorno.add(tokenLista);

            for (String chefesDeFamilia : listaRetorno) {
                if (insereValor.equalsIgnoreCase(chefesDeFamilia)) {
                    return valorRetornadoComSucesso = insereValor;
                }
            }
        }
            valorRetornadoComSucesso = "Valor não encontrado";
        // PROCURAR UMA FORMA DE ARMAZENAR O VALOR QUE FOR DIGITADO NO TELEGRAM LER DOCUMENTAÇÃO

        return valorRetornadoComSucesso;
    }

// CRIAR OUTRO METODO SOMENTE PRA O CELULAR
    public static void main(String[] args) throws SQLException {
        TokenDigitado ts = new TokenDigitado();
        System.out.println(ts.tokenDigitadoTelegram());

    }
}