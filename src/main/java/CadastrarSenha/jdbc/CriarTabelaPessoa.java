package CadastrarSenha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarTabelaPessoa {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost/Pessoas";
        final String usuario = "root";
        final String senha = "0000";


        try {
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
