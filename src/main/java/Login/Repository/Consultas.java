package Login.Repository;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consultas {

    public void criarTabelaTokens() throws SQLException, ClassNotFoundException {

        Connection conexao = CriarConexao.getConnetion();
        String sql = "CREATE DATABASE testandoBANCO2";
        conexao.prepareStatement(sql);

    }

    public void pesquisarBanco() throws SQLException, ClassNotFoundException {

        Connection conexao = CriarConexao.getConnetion();
        Scanner leia = new Scanner(System.in);
        System.out.println("DIGITE SUA SENHA TOKEN");
        String pesquisaNumero = leia.nextLine();

        String sql = "SELECT token,NOME_DO_MEIO FROM moradores.tbl_consultas tc WHERE TOKEN = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1,pesquisaNumero);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaToken = new ArrayList<>();
        while (rs.next()) {
            String codigo = rs.getString("token");
            String sobrenome = rs.getString("nome_do_meio");
            String.valueOf(listaToken.add(codigo));
            String.valueOf(listaToken.add(sobrenome));
//            System.out.println("Token: " + codigo + ", Nome do Meio: " + sobrenome); USAR PARA OUTRA FUNCIONALIDADE
        }

        if (listaToken.contains(pesquisaNumero)) {
            System.out.println("NUMERO ENCONTRADO => " + pesquisaNumero);
            System.out.println("Confirme seu nome do meio");
            String sobrenome = leia.nextLine();

            if (listaToken.contains(sobrenome)) {
                System.out.println("ACESSO CONCEDIDO!");
            } else {
                System.out.println("ACESSO NEGADO");
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Consultas consultas = new Consultas();
        consultas.pesquisarBanco();
    }

}
