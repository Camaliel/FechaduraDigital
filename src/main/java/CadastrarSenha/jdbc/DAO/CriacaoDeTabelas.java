package CadastrarSenha.jdbc.DAO;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class CriacaoDeTabelas {
    public void criarTabelaTokens() throws ClassNotFoundException, SQLException {

            Connection conexao = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE teste";
            conexao.prepareStatement(sql);

            System.out.println("Tabela CRIADA com sucesso");

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CriacaoDeTabelas teste = new CriacaoDeTabelas();
        teste.criarTabelaTokens();
    }
}

