package CadastrarSenha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
    public static Connection getConnetion(){
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
