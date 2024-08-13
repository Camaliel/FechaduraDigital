package Login;


import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    public String loginDeAcesso() throws SQLException {
        Scanner leia = new Scanner(System.in);

        // TODO CRIAR UMA REFERENCIA NO NOME DE QUEM SOLICITOU EXEMPLO NOME: DEBORA TOKEN: 000996

        System.out.println("Digite seu numero de acesso !");
        String loginTeclado = leia.nextLine();
        Connection conexao = CriarConexao.getConnetion();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TOKENS");
        String token = "";
        String loginConfere = "";
        while (rs.next()){
            token = rs.getString("token");
            if (token.contains(loginTeclado)){
                System.out.println("-----------------");
                System.out.println("Seu login confere");
                loginConfere = loginTeclado;
                System.out.println("-----------------");
            }
        }
        return loginConfere;
    }

    public static void main(String[] args) throws SQLException {
        Login teste = new Login();
        System.out.println(teste.loginDeAcesso());
    }
}