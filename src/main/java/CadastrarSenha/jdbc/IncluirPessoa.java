package CadastrarSenha.jdbc;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class IncluirPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner leia = new Scanner(System.in);
        System.out.println("Inclua um nome ..");
        String nome = leia.nextLine();

        Connection conexao = CriarTabelaPessoa.getConnection();
        String sql = "INSERT INTO pessoas (nome) VALUES(?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1,nome);

        statement.execute();

        System.out.println("Pessoa incluida com sucesso ...");
        leia.close();



    }
}
