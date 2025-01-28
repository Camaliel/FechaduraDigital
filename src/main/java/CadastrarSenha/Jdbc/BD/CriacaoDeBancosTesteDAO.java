package CadastrarSenha.Jdbc.BD;

import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDeBancosTesteDAO {

    public void bancoMoradoresTeste() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE moradores-teste";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados já CONSTA no cadastro");
        }
    }
    public void criarTabelaTokensTeste() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE Tokens-teste";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados já CONSTA no cadastro");
        }
    }
    public void bancoAdministradorTeste() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE administrador-teste";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados [ADMINISTRADOR] criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados [ADMINISTRADOR] já CONSTA no cadastro");
        }
    }


    public void tabelaMoradoresTokensTeste() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql = " CREATE TABLE moradores.tokens-teste (" +
                    "  parentesco varchar(10)," +
                    "  token VARCHAR(6) primary key," +
                    "  chefe_familia VARCHAR(3)," +
                    "  nome varchar(15)" +
                    ");";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela [TOKENS] criada com sucesso ...");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [TOKENS]");
        }
    }

    public void tabelaAdministradorTokensTeste() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql = " CREATE TABLE administrador.tokens-teste (" +
                    " id INT " +
                    "  parentesco varchar(10)," +
                    "  token VARCHAR(6) primary key," +
                    "  chefe_familia VARCHAR(3)," +
                    "  nome varchar(15)" +
                    ");";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela [TOKENS-ADM] criada com sucesso ...");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [TOKENS-ADM]");
        }
    }
    public void tbl_consultaTeste() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql ="CREATE TABLE moradores.tbl_consultas-teste ( "+
                    "    nome VARCHAR(50)," +
                    "    nome_do_meio VARCHAR(50)," +
                    "    ultimo_nome VARCHAR(50)," +
                    "    token VARCHAR(6) PRIMARY KEY," +
                    "    CONSTRAINT fk_token FOREIGN KEY (token) REFERENCES tokens (token) "+
                    ")";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela [CONSULTAS] criada com sucesso ...");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [CONSULTAS]");
        }
    }

    public void tabelaCadastroTeste() throws ClassNotFoundException, SQLException {
        Connection conexao = CriarConexao.getConnetion();
        try {
        String sql = " CREATE TABLE cadastro-teste (" +
                "nome VARCHAR(80) NOT NULL," +
                "nome_do_meio VARCHAR(80)," +
                "ultimo_nome VARCHAR(80)," +
                "chefe_familia VARCHAR(3)," +
                "parentesco VARCHAR(10)," +
                "cpf VARCHAR(12) primary key," +
                "tel INT," +
                "senha INT" +
                ")";

            Statement statement = conexao.createStatement();
            statement.execute(sql);
            System.out.println("Tabela [CADASTRO] criada com sucesso ...");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [CADASTRO]");
        }
    }

    public void tabelaHistoricoTeste() throws ClassNotFoundException, SQLException {
        Connection conexao = CriarConexao.getConnetion();
        try {
            String sql = "CREATE TABLE moradores.historico-teste (" +
                    "     token varchar(6) primary key ," +
                    "     nome varchar(50)," +
                    "     nome_do_meio varchar(50)," +
                    "     ultimo_nome varchar(50)," +
                    "     data varchar(10)," +
                    "     hora varchar(10)," +
                    "     parentesco varchar(10)," +
                    "     status varchar(10)," +
                    ");";

            Statement statement = conexao.createStatement();
            statement.execute(sql);
            System.out.println("Tabela [HISTORICO] criada com sucesso ...");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [HISTORICO]");
        }
    }

    /*
    * AUTOMAÇÃO DAS CRIAÇÕES DE TABELAS ... PODE SER MELHORADO COM O PROPERTIES
    * */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CriacaoDeBancosTesteDAO criacaoDeBancosDAO = new CriacaoDeBancosTesteDAO();
        criacaoDeBancosDAO.tabelaCadastroTeste();
        criacaoDeBancosDAO.tbl_consultaTeste();
        criacaoDeBancosDAO.tabelaHistoricoTeste();
        criacaoDeBancosDAO.bancoAdministradorTeste();
        criacaoDeBancosDAO.tabelaMoradoresTokensTeste();
        criacaoDeBancosDAO.tabelaAdministradorTokensTeste();
    }
}