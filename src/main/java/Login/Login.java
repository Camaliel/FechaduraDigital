package Login;

import CadastrarSenha.jdbc.DAO.Conexao;

import java.util.ArrayList;
import java.util.Scanner;


public class Login {

    public void loginDeAcesso(){
        Scanner leia = new Scanner(System.in);
        Conexao DAO = new Conexao();
        ArrayList<Integer>ListaTokenSenha = new ArrayList<>();

        int login = leia.nextInt();

       String sql = "select * from tokens where (token) = 'login'";
       DAO.incluir(sql,login);




        ListaTokenSenha.add(Integer.valueOf(sql));

        DAO.close();



    }

    public static void main(String[] args) {
        Login teste = new Login();
        teste.loginDeAcesso();
    }
}
