package CadastrarSenha.Repository.Login;


import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginRepository {


    public void acessoLogin() throws SQLException {
        loginDeAcessoComSucesso();
    }



    private String loginDeAcessoComSucesso() throws SQLException {
        Scanner leia = new Scanner(System.in);

        /*
         * Pagina de acesso do programa, ao acertar a senha, libera o acesso ...
         * */

        System.out.println("Digite seu numero de acesso !");
        String loginTeclado = leia.nextLine();
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT moradores.tokens , moradores.nome FROM moradores.tokens WHERE token = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, loginTeclado);
        String loginConfere = "";
        String token = "";
        String nome = "";

        ResultSet rs = stmt.executeQuery();
        ArrayList<String> listaLogin = new ArrayList<>();

        while (rs.next()) {
            token = rs.getString("token");
            nome = rs.getString("nome");
            listaLogin.add(token);
            listaLogin.add(nome);
        }

        if (token.equals(loginTeclado)) {
            System.out.println("Seu token [ ****** ] confere ");
            System.out.println("Bem-Vindo: " + nome);
        } else {
            System.out.println("Seu token [ ****** ] não confere");
            System.out.println("FIM.");
        }
        return loginConfere;
    }
}