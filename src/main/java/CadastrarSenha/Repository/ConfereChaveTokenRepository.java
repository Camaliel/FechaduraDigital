package CadastrarSenha.Repository;

import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Service.GeradorDeChaveTokenService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TODO ANALISAR PARA APAGAR A CLASSE !!! [LEMBRETE]
public class ConfereChaveTokenRepository {

    IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
    GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();

    public String validaChaveToken() throws SQLException, ClassNotFoundException {
        String valorGuardado = "";

        Scanner leia = new Scanner(System.in);
//        System.out.println("token => " + incluiTokenRepository.incluiTokenAdministracao());
        System.out.print("DIGITE SEU NUMERO TOKEN ==> ");
        String valorDigitado = leia.nextLine();
            while (!geradorDeChaveTokenService.getPegaToken().equals(valorDigitado)) {
                System.out.println(" TOKEN InVALIDO");
                System.out.print("DIGITE OUTRO NUMERO TOKEN ==> ");
                valorDigitado = leia.nextLine();
                break;
            }
            valorGuardado = valorDigitado;
            leia.close();
        return valorGuardado;
    }

    public String consultaQueryAdministracao() throws SQLException, ClassNotFoundException {

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