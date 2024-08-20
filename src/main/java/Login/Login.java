package Login;


import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    public String loginDeAcessoComSucesso() throws SQLException {
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
        while (rs.next()){
            token = rs.getString("token");
            nome = rs.getString("nome");
            if (token.contains(loginTeclado)){
                System.out.println("-----------------");
                System.out.println("Bem vindo !");
                loginConfere = nome;
                System.out.println("-----------------");
                System.out.print("Acesso liberado ");
            }
        }
        return loginConfere;
    }

    public String loginDeAcessoComErro(){



        return "";
    }

    public static void main(String[] args) throws SQLException {
        Login teste = new Login();
        System.out.println(teste.loginDeAcessoComSucesso());
    }
}