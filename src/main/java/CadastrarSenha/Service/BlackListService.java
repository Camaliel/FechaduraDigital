package CadastrarSenha.Service;

import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Repository.HistoricoRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlackListService {

    public static String testandoValor = "";

    Conexao DAO = new Conexao();
    HistoricoRepository repository = new HistoricoRepository();



//        public List<String> bloquearUsuario() throws SQLException {
//            String registro = "";
//        Connection connection = CriarConexao.getConnetion();
//        String sql = "SELECT TOKEN FROM MORADORES.TOKENS ";
//        connection.prepareStatement(sql); // Linha inútil
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        List<String> listaToken = new ArrayList<>();
//            while (resultSet.next()) {
//                String token = resultSet.getString("TOKEN");
//                registro = token ;
//                listaToken.add(registro);
//            }
//
//        return listaToken;
//    }

    public Object bloquearUsuario() throws SQLException {
        String registro = "";
        Connection conexao = CriarConexao.getConnetion();
        String sql = "SELECT token  FROM MORADORES.TOKENS;";

        conexao.prepareStatement(sql);
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<String> listaMesAnterior = new ArrayList<>();
        String teste = "Token  \n";
        listaMesAnterior.add(teste);
        while (rs.next()) {

            String tokenLista = rs.getString("TOKEN");

            registro =  tokenLista +"\n";
            listaMesAnterior.add(registro);
        }

        return listaMesAnterior;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        BlackListService service = new BlackListService();
        System.out.println(   service.bloquearUsuario());
////        service.removeDaListaNegra();
    }
}