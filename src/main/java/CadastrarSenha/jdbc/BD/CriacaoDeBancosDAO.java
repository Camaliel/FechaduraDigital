package CadastrarSenha.jdbc.BD;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDeBancosDAO {

// REFATORAR CODIGO CRIAR METODOS PARA CADA SITUAÇÃO
    // TODO CRIAR DATABASE  (SE TIVER APARECER MENSAGEM) ...DAR NOME GENERICO ok
    // TODO CRIAR TABELAS (SE TIVER APARECER MENSAGEM) ...TOKENS ok
    // TODO CRIAR TABELA (SE TIVER APARECER MENSAGEM) ...PESSOAS
    // TODO CRIAR TABELA (SE TIVER APARECER MENSAGEM) ...ADMINISTRADOR


    public void bancoMoradores() throws ClassNotFoundException, SQLException {
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
    public void bancoAdministrador() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE administrador";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados [ADMINISTRADOR] criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados [ADMINISTRADOR] já CONSTA no cadastro");
        }
    }


    public void tabelaMoradoresTokens() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql = " CREATE TABLE moradores.tokens (" +
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

    public void tabelaAdministradorTokens() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql = " CREATE TABLE administrador.tokens (" +
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
    public void tbl_consulta() throws SQLException {
        try {
            Connection conexao = CriarConexao.getConnetion();
            String sql ="CREATE TABLE moradores.tbl_consultas ( "+
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

    public void tabelaCadastro() throws ClassNotFoundException, SQLException {
        Connection conexao = CriarConexao.getConnetion();
        try {
        String sql = " CREATE TABLE cadastro (" +
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
    public void tabelaHistorico() throws ClassNotFoundException, SQLException {
        Connection conexao = CriarConexao.getConnetion();
        try {
            String sql = "CREATE TABLE moradores.historico (" +
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CriacaoDeBancosDAO criacaoDeBancosDAO = new CriacaoDeBancosDAO();
        criacaoDeBancosDAO.tabelaCadastro();
        criacaoDeBancosDAO.tbl_consulta();
        criacaoDeBancosDAO.tabelaHistorico();
        criacaoDeBancosDAO.bancoAdministrador();
        criacaoDeBancosDAO.tabelaMoradoresTokens();
        criacaoDeBancosDAO.tabelaAdministradorTokens();
    }
}