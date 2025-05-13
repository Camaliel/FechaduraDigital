package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Entities.GuardaTokenEntity;
import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Service.AcessoHistoricoService;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TokenDigitado {
    Scanner leia = new Scanner(System.in);
    Connection conexao = CriarConexao.getConnetion();
     static String insereValor = "000";


    public Object tokenDigitadoTelegram() throws SQLException {
        String registro = "";
        String tokenLista = "";

        String sql = "SELECT * FROM MORADORES.HISTORICO;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaRetorno = new ArrayList<>();
        String texto = "digite um valor";
        listaRetorno.add(texto);
        while (rs.next()) {
            tokenLista = rs.getString("TOKEN");

            registro = tokenLista;
            listaRetorno.add(registro);

        }

        // PROCURAR UMA FORMA DE ARMAZENAR O VALOR QUE FOR DIGITADO NO TELEGRAM LER DOCUMENTAÇÃO

        String valor = leia.next();
        if (listaRetorno.contains(valor)) {
            insereValor = valor;
        }
        return valor;
    }

    public Object menuCelularTelegram() throws SQLException {
        String texto = "\"Escolha uma Opção | 1 historico ...\"";

        return texto;

    }
// CRIAR OUTRO METODO SOMENTE PRA O CELULAR

    public static void main(String[] args) throws SQLException {
//        TokenDigitado ts = new TokenDigitado();
//        System.out.println(ts.tokenDigitadoTelegram());


    }
}
