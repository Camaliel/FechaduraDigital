package CadastrarSenha.Repository.Login;

import CadastrarSenha.Repository.HistoricoRepository;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;
import CadastrarSenha.Jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultasRepository {

    static Scanner leia = new Scanner(System.in);
    static ConsultasRepository consultasRepository = new ConsultasRepository();
    public static String salvaTokenDigitado = "";
    public static String consultaParentesco = "";
    public static String status = "";
    VariaveisHistorico variaveisHistorico = new VariaveisHistorico();

    public List<String> obtemInformacoesBD() throws SQLException, ClassNotFoundException {
        Connection conexao = CriarConexao.getConnetion();
        System.out.println("DIGITE SUA SENHA TOKEN");
        String pesquisaNumero = leia.nextLine();
        salvaTokenDigitado = pesquisaNumero;
        String sql = "SELECT \n" +
                "    tc.NOME, \n" +
                "    tc.NOME_DO_MEIO, \n" +
                "    tc.ULTIMO_NOME, \n" +
                "    tc.TOKEN, \n" +
                "    c.parentesco\n" +
                "FROM \n" +
                "    moradores.tbl_consultas tc\n" +
                "JOIN \n" +
                "    moradores.cadastro c\n" +
                "ON \n" +
                "    tc.NOME = c.nome\n" +
                "WHERE \n" +
                "    tc.TOKEN = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, pesquisaNumero);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaToken = new ArrayList<>();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String sobrenome = rs.getString("nome_do_meio");
            String ultimoNome = rs.getString("ultimo_nome");
            String token = rs.getString("token");
            String.valueOf(listaToken.add(nome));
            String.valueOf(listaToken.add(sobrenome));
            String.valueOf(listaToken.add(ultimoNome));
            String.valueOf(listaToken.add(token));
            status = "LIBERADO";
        }

        return listaToken;
    }

    public String pesquisaNaListaDeUsuarios() throws SQLException, ClassNotFoundException {

        String retornaToken = String.valueOf(consultasRepository.obtemInformacoesBD());
        if (retornaToken.contains(salvaTokenDigitado)) {
            System.out.println("NUMERO ENCONTRADO => " + salvaTokenDigitado);
            System.out.println("Confirme seu nome do meio");
            String sobrenome = leia.nextLine();
            if (sobrenome.isEmpty()) {
                System.out.println("ACESSO NEGADO! Nome do [MEIO] não pode estar vazio");
                return null;
            }
            HistoricoRepository repository = new HistoricoRepository();
            if (retornaToken.contains(sobrenome)) {
                System.out.println("ACESSO CONCEDIDO!");
                repository.enviaHistorico(salvaTokenDigitado, "Oculto", sobrenome, "Oculto", variaveisHistorico.getData(), variaveisHistorico.getHora(), consultaParentesco, "Liberado");
            } else {
                System.out.println("ACESSO NEGADO!");
                repository.enviaHistorico(salvaTokenDigitado, "Oculto", sobrenome, "Oculto", variaveisHistorico.getData(), variaveisHistorico.getHora(), consultaParentesco, "Liberado");
                System.out.println("Digite seu [ULTIMO] nome");
                String ultimoNome = leia.nextLine();
                if (ultimoNome.isEmpty()) {
                    System.out.println("ACESSO NEGADO! [ULTIMO] nome nao pode estar vazio");
                    repository.enviaHistorico(salvaTokenDigitado, "Oculto", sobrenome, "Oculto", variaveisHistorico.getData(), variaveisHistorico.getHora(), consultaParentesco, "Liberado");
                } else if (retornaToken.contains(ultimoNome)) {
                    System.out.println("ACESSO CONCEDIDO!");
                    repository.enviaHistorico(salvaTokenDigitado, "Oculto", sobrenome, "Oculto", variaveisHistorico.getData(), variaveisHistorico.getHora(), consultaParentesco, "Liberado");
                } else {
                    System.out.println("ACESSO NEGADO!");
                    repository.enviaHistorico(salvaTokenDigitado, "Oculto", sobrenome, "Oculto", variaveisHistorico.getData(), variaveisHistorico.getHora(), consultaParentesco, "Liberado");
                }
            }
        }
        leia.close();
        return salvaTokenDigitado;
    }
}