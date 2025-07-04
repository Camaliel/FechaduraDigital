package CadastrarSenha.Jdbc.BD;

import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDeBancosDAO {

    public void bancoMoradores() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE MORADORES;";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Banco de dados [ADMINISTRADOR] criado com SUCESSO");

        } catch (SQLException e) {
            System.out.println("Banco de dados [ADMINISTRADOR] já CONSTA no cadastro");
        }
    }

    public void criarTabelaTokens() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = CriarConexao.getConnetion();
            String sql = "CREATE DATABASE MORADORES.TOKENS";

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
            String sql = "CREATE DATABASE ADMINISTRADOR";

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
            String sql = " CREATE TABLE MORADORES.TOKENS (" +
                    "  ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "  NOME varchar(15)," +
                    "  PARENTESCO varchar(10)," +
                    "  TOKEN VARCHAR(6) NOT NULL," +
                    "  CHEFE_FAMILIA VARCHAR(3)" +
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
            String sql = " CREATE TABLE ADMINISTRADOR.TOKENS (\n" +
                    " ID INT,\n" +
                    " PARENTESCO varchar(10),\n" +
                    " TOKEN VARCHAR(6) primary key,\n" +
                    " CHEFE_FAMILIA VARCHAR(3),\n" +
                    " NOME varchar(15)\n" +
                    " );";

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
            String sql = "CREATE TABLE MORADORES.TBL_CONSULTAS (\n" +
                    " ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    " NOME VARCHAR(50),\n" +
                    " NOME_DO_MEIO VARCHAR(50),\n" +
                    " ULTIMO_NOME VARCHAR(50),\n" +
                    " TOKEN VARCHAR(6)\n" +
                    " );";

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
            String sql = " CREATE TABLE MORADORES.CADASTRO (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOME VARCHAR(80) NOT NULL," +
                    "NOME_DO_MEIO VARCHAR(80)," +
                    "ULTIMO_NOME VARCHAR(80)," +
                    "CHEFE_FAMILIA VARCHAR(3)," +
                    "PARENTESCO VARCHAR(10)," +
                    "CPF VARCHAR(12)," +
                    "TEL INT," +
                    "SENHA INT" +
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
            String sql = "CREATE TABLE MORADORES.HISTORICO (\n" +
                    " ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    " TOKEN varchar(6),\n" +
                    " NOME varchar(50),\n" +
                    " NOME_DO_MEIO varchar(50),\n" +
                    " ULTIMO_NOME varchar(50),\n" +
                    " DATA varchar(10),\n" +
                    " HORA varchar(10),\n" +
                    " PARENTESCO varchar(10),\n" +
                    " STATUS varchar(10)\n" +
                    " );";

            Statement statement = conexao.createStatement();
            statement.execute(sql);
            System.out.println("Tabela [HISTORICO] criada com sucesso ...");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [HISTORICO]");
        }
    }

    public void listaNegra() throws SQLException {
        //INSERT INTO MORADORES.LISTA_NEGRA (NOME, SOBRENOME, ULTIMO_NOME, BLOQUEADO_POR, TOKEN, DESBLOQUEADO_POR, DIA, HORA
        Connection connection = CriarConexao.getConnetion();
        try {
            String sql = "CREATE TABLE MORADORES.LISTA_NEGRA (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOME VARCHAR(50)," +
                    "SOBRENOME VARCHAR(50)," +
                    "ULTIMO_NOME VARCHAR(50)," +
                    "BLOQUEADO_POR VARCHAR(10)," +
                    "TOKEN VARCHAR(6)," +
                    "DESBLOQUEADO_POR VARCHAR(10)," +
                    "DATA VARCHAR(10)," +
                    "HORA VARCHAR(10)" +
                    ");";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Tabela [LISTA NEGRA] criada com sucesso ...");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela [LISTA NEGRA]");
        }
    }

    /*
     * AUTOMAÇÃO DAS CRIAÇÕES DE TABELAS ... PODE SER MELHORADO COM O PROPERTIES
     * */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CriacaoDeBancosDAO criacaoDeBancosDAO = new CriacaoDeBancosDAO();
        criacaoDeBancosDAO.bancoMoradores();
        criacaoDeBancosDAO.bancoAdministrador();
        criacaoDeBancosDAO.tabelaCadastro();
        criacaoDeBancosDAO.tabelaHistorico();
        criacaoDeBancosDAO.tabelaMoradoresTokens();
        criacaoDeBancosDAO.tabelaAdministradorTokens();
        criacaoDeBancosDAO.tbl_consulta();
        criacaoDeBancosDAO.listaNegra();

    }
}