package CadastrarSenha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost";
        final String usuario = "root";
        final String senha = "0000";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        System.out.println("Conexão efetuada com sucesso");
        conexao.close();
    }
}
