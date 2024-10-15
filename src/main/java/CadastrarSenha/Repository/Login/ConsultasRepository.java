package CadastrarSenha.Repository.Login;

import CadastrarSenha.Repository.HistoricoRepository;
import CadastrarSenha.jdbc.CriarConexao;

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
    String salvaTokenDigitado = "";
    String consultaParentesco = "";

    public List<String> obtemInformacoesBD() throws SQLException, ClassNotFoundException {
        Connection conexao = CriarConexao.getConnetion();
        System.out.println("DIGITE SUA SENHA TOKEN");
        String pesquisaNumero = leia.nextLine();
        salvaTokenDigitado = pesquisaNumero;
        String sql = "SELECT tc.NOME, tc.NOME_DO_MEIO, tc.ULTIMO_NOME, tc.TOKEN, c.parentesco " +
                "FROM tbl_consultas tc JOIN cadastro c \n" +
                "ON tc.NOME = c.nome  \n" +
                "WHERE tc.TOKEN = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, pesquisaNumero);

        ResultSet rs = preparedStatement.executeQuery();

        List<String> listaToken = new ArrayList<>();
        while (rs.next()) {
            String codigo = rs.getString("token");
            String sobrenome = rs.getString("nome_do_meio");
            String ultimoNome = rs.getString("ultimo_nome");
            String parentesco = rs.getString("parentesco");
            String.valueOf(listaToken.add(codigo));
            String.valueOf(listaToken.add(sobrenome));
            String.valueOf(listaToken.add(ultimoNome));
            String.valueOf(listaToken.add(parentesco));
            consultaParentesco = parentesco;
//            System.out.println("Token: " + codigo + ", Nome do Meio: " + sobrenome); USAR PARA OUTRA FUNCIONALIDADE
        }

        return listaToken;
    }

    public String pesquisaNaListaDeUsuarios() throws SQLException, ClassNotFoundException {

        String retornaToken = String.valueOf(consultasRepository.obtemInformacoesBD());
        if (retornaToken.contains(salvaTokenDigitado)){
            System.out.println("NUMERO ENCONTRADO => " + salvaTokenDigitado);
            System.out.println("Confirme seu nome do meio");
            String sobrenome = leia.nextLine();

            if (sobrenome.isEmpty()){
                System.out.println("ACESSO NEGADO! Nome do [MEIO] não pode estar vazio");
                return null;
            }
            HistoricoRepository repository = new HistoricoRepository();
            if (retornaToken.contains(sobrenome)) {
                System.out.println("ACESSO CONCEDIDO!");
                repository.enviaHistorico(consultaParentesco,"LIBERADO");

            } else {
                System.out.println("ACESSO NEGADO!");
                System.out.println("Digite seu ultimo nome");
                String ultimoNome = leia.nextLine();
                if (ultimoNome.isEmpty()) {
                    System.out.println("ACESSO NEGADO! [ULTIMO] nome nao pode estar vazio");
                    repository.enviaHistorico(consultaParentesco,"NEGADO");
                } else if (retornaToken.contains(ultimoNome)){
                    System.out.println("ACESSO CONCEDIDO!");
                    repository.enviaHistorico(consultaParentesco,"LIBERADO");
                }else {
                    System.out.println("ACESSO NEGADO!");
                    repository.enviaHistorico(consultaParentesco,"NEGADO");
                }
            }
        }
        leia.close();
        return salvaTokenDigitado;

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(consultasRepository.pesquisaNaListaDeUsuarios());

    }
}