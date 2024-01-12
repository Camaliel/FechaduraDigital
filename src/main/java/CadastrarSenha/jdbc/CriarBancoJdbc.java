package CadastrarSenha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoJdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost";
        final String usuario = "root";
        final String senha = "0000";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        Statement stmt = conexao.createStatement();

        stmt.execute("CREATE DATABASE testandoConexao");

        System.out.println("Banco criado com sucesso!!!");
        conexao.close();
    }
}
