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

    public String tokenDigitadoTelegram() throws SQLException {
        String tokenLista;

        String sql = "SELECT TOKEN FROM MORADORES.TOKENS;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaRetorno = new ArrayList<>();
        while (rs.next()) {
            tokenLista = rs.getString("TOKEN");

            listaRetorno.add(tokenLista);
        }

        for (String nomes : listaRetorno) {
            System.out.println(nomes);
            if (insereValor.equals(nomes)) {
                return valorRetornadoComSucesso = insereValor;
            }
        }

        //TODO CRIAR LOGICA PARA APENAS OS ADMINS ENTRAREM NA OPÇÃO
        
        // PROCURAR UMA FORMA DE ARMAZENAR O VALOR QUE FOR DIGITADO NO TELEGRAM LER DOCUMENTAÇÃO

        return null;
    }


// CRIAR OUTRO METODO SOMENTE PRA O CELULAR

    public static void main(String[] args) throws SQLException {
        TokenDigitado ts = new TokenDigitado();
        System.out.println(ts.tokenDigitadoTelegram());

    }
}