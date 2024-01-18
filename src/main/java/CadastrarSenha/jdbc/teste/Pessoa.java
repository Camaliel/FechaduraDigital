package CadastrarSenha.jdbc.teste;

import CadastrarSenha.jdbc.CriarTabelaPessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Pessoa {


    public static void main(String[] args) throws SQLException {
        Scanner leia = new Scanner(System.in);
        System.out.println("INSIRA UM NOME .. ");
        String nome = leia.nextLine();

        Connection conexao = CriarTabelaPessoa.getConnection();
        String Sql =  " CREATE TABLE Token-Teste (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(80) NOT NULL," +
                "campo INT,"+
                "senha INT NOT NULL,"+
                "tel INT NOT NULL"+
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(Sql);

        System.out.println("Tabela criada com sucesso ...");
        conexao.close();

    }
}
