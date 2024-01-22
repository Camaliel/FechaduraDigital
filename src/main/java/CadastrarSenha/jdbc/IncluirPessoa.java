package CadastrarSenha.jdbc;

import CadastrarSenha.Util.Variavel.VarFamiliar;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class IncluirPessoa {



    public void incluirPessoaFamilia() throws SQLException {
        Scanner leia = new Scanner(System.in);


        System.out.println("Inclua um nome ..");
        String nome = leia.nextLine();

        Connection conexao = CriarConexao.getConnetion();
        String sql = "INSERT INTO pessoas (nome) VALUES(?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1,nome);

        statement.execute();

        System.out.println("Pessoa incluida com sucesso ...");
        leia.close();



    }
}
