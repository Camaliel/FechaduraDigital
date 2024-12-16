package CadastrarSenha.Repository.Login;


import CadastrarSenha.jdbc.CriarConexao;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginRepository {

    Connection conexao = CriarConexao.getConnetion();

    private String loginDeAcessoComSucesso() throws SQLException {
        Scanner leia = new Scanner(System.in);

        /*
         * Pagina de acesso do programa, ao acertar a senha, libera o acesso ...
         * */

        System.out.println("Digite seu numero de acesso !");
        String loginTeclado = leia.nextLine();
        Connection conexao = CriarConexao.getConnetion();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TOKENS");
        String token = "";
        String nome = "";
        String loginConfere = "";
        while (rs.next()) {
            token = rs.getString("token");
            nome = rs.getString("nome");
            if (token.contains(loginTeclado)) {
                System.out.println("-----------------");
                System.out.println("Bem vindo !");
                loginConfere = nome;
                System.out.println("-----------------");
                System.out.print("Acesso liberado ");
            }
        }
        return loginConfere;
    }

    // TODO VER QUAL ESTA MELHOR PARA MANTE-LO
//    public String loginDeAcessoComErro() throws SQLException {
//        Scanner leia = new Scanner(System.in);
//        System.out.println("Digite seu numero de acesso !");
//        String senha = leia.nextLine();
//        String resposta = "";
//
//        Conexao DAO = new Conexao();
//        String sql = "SELECT  token FROM tokens t ";
//        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
//
//        ResultSet rs = preparedStatement.executeQuery();
//        List<String> confereToken = new ArrayList<>();
//        while (rs.next()) {
//            String token = rs.getString("token");
//            String.valueOf(confereToken.add(token));
//        }
//        if (confereToken.contains(senha)) {
//            resposta = "Sua senha [" + senha + "] confere !";
//        } else {
//            resposta = "Senha nao confere";
//        }
//        return resposta;
//    }

    public static void main(String[] args) throws SQLException {
        LoginRepository teste = new LoginRepository();
        System.out.println(teste.loginDeAcessoComSucesso());

    }
}