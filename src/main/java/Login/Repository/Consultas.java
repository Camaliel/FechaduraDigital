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

    public void atribuirValoresBanco() throws SQLException {

    }

    public void pesquisarBanco() throws SQLException, ClassNotFoundException {

        String numeroEncontrado = "";

        Connection conexao = CriarConexao.getConnetion();
        Scanner leia = new Scanner(System.in);
        String teste = "227764";
        String pesquisaNumero = leia.nextLine();
        String numeroToken = "";

        String sql = "select * from tokens";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<String> lista = new ArrayList<>();
        while (rs.next()) {
            String codigo = rs.getString("token");
            String.valueOf(lista.addAll(Collections.singleton(codigo)));
            numeroToken = codigo;

        }

        if (lista.contains(pesquisaNumero)) {
            numeroEncontrado = pesquisaNumero;
            System.out.println("NUMERO ENCONTRADO => " + numeroEncontrado);

        } else {
            System.out.println("NAO ENCONTRADO");
        }
    }

    public void alterarBanco() {

    }

    public void apagarInfoBanco() {

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Consultas consultas = new Consultas();
        consultas.pesquisarBanco();
    }

}
