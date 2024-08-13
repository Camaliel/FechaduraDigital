package CadastrarSenha.jdbc.BD;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDeBancos {

// REFATORAR CODIGO CRIAR METODOS PARA CADA SITUAÇÃO
    // TODO CRIAR DATABASE  (SE TIVER APARECER MENSAGEM) ...DAR NOME GENERICO ok
    // TODO CRIAR TABELAS (SE TIVER APARECER MENSAGEM) ...TOKENS ok
    // TODO CRIAR TABELA (SE TIVER APARECER MENSAGEM) ...PESSOAS
    // TODO CRIAR TABELA (SE TIVER APARECER MENSAGEM) ...ADMINISTRADOR


    public void CriarTabelaMoradores() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE moradores";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados já CONSTA no cadastro");
        }
    }
    public void criarTabelaTokens() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE Tokens";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados já CONSTA no cadastro");
        }
    }
    public void criarTabelaAdministrador() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE administrador";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados já CONSTA no cadastro");
        }
    }


    public void tabelaTokens() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql = " CREATE TABLE tokens (" +
                    "id INT AUTO_INCREMENT, " +
                    "nome VARCHAR(80)," +
                    "campo INT," +
                    "token VARCHAR(10)," +
                    "PRIMARY KEY (nome)" +
                    ")";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela criada com sucesso ...");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela");
        }
    }

    public void tabelaCadastro() throws ClassNotFoundException, SQLException {
        Connection conexao = CriarConexao.getConnetion();
        try {
        String sql = " CREATE TABLE cadastro (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(80) NOT NULL," +
                "chefe_familia VARCHAR(3)," +
                "parentesco VARCHAR(10)," +
                "cpf VARCHAR(12)," +
                "tel INT," +
                "senha INT" +
                ")";
//nome, chefe_familia, parentesco,cpf, tel, senha
            Statement statement = conexao.createStatement();
            statement.execute(sql);
            System.out.println("Tabela criada com sucesso ...");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CriacaoDeBancos criacaoDeBancos = new CriacaoDeBancos();
//        criacaoDeBancos.CriarTabelaMoradores();
//        criacaoDeBancos.tabelaCadastro();
        criacaoDeBancos.tabelaTokens();

    }
}