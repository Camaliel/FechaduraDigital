package Login.Repository;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Consultas {

    static Scanner leia = new Scanner(System.in);
    static Consultas consultas = new Consultas();
    String salvaTokenDigitado = "";


    public void criarTabelaTokens() throws SQLException, ClassNotFoundException {
        Connection conexao = CriarConexao.getConnetion();
        String sql = "CREATE DATABASE testandoBANCO2";
        conexao.prepareStatement(sql);
    }

    public List<String> obtemInformacoesBD() throws SQLException, ClassNotFoundException {
        Connection conexao = CriarConexao.getConnetion();
        System.out.println("DIGITE SUA SENHA TOKEN");
        String pesquisaNumero = leia.nextLine();
        salvaTokenDigitado = pesquisaNumero;
        String sql = "SELECT token,NOME_DO_MEIO,ULTIMO_NOME FROM moradores.tbl_consultas tc WHERE TOKEN = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, pesquisaNumero);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaToken = new ArrayList<>();
        while (rs.next()) {
            String codigo = rs.getString("token");
            String sobrenome = rs.getString("nome_do_meio");
            String ultimoNome = rs.getString("ultimo_nome");
            String.valueOf(listaToken.add(codigo));
            String.valueOf(listaToken.add(sobrenome));
            String.valueOf(listaToken.add(ultimoNome));
//            System.out.println("Token: " + codigo + ", Nome do Meio: " + sobrenome); USAR PARA OUTRA FUNCIONALIDADE
        }

        return listaToken;
    }

    public String pesquisaNaListaDeUsuarios() throws SQLException, ClassNotFoundException {

        String retornaToken = String.valueOf(consultas.obtemInformacoesBD());
        if (retornaToken.contains(salvaTokenDigitado)){
            System.out.println("NUMERO ENCONTRADO => " + salvaTokenDigitado);
            System.out.println("Confirme seu nome do meio");
            String sobrenome = leia.nextLine();

            if (sobrenome.isEmpty()){
                System.out.println("ACESSO NEGADO! Nome do [MEIO] não pode estar vazio");
                return null;
            }

            if (retornaToken.contains(sobrenome)) {
                System.out.println("ACESSO CONCEDIDO!");
            } else {
                System.out.println("ACESSO NEGADO!");
                System.out.println("Digite seu ultimo nome");
                String ultimoNome = leia.nextLine();
                if (ultimoNome.isEmpty()) {
                    System.out.println("ACESSO NEGADO! [ULTIMO] nome nao pode estar vazio");
                } else if (retornaToken.contains(ultimoNome)){
                    System.out.println("ACESSO CONCEDIDO!");
                }else {
                    System.out.println("ACESSO NEGADO!");
                }
            }
        }
        leia.close();
        return salvaTokenDigitado;

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(consultas.pesquisaNaListaDeUsuarios());

    }
}