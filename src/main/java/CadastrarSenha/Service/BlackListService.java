package CadastrarSenha.Service;

import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Jdbc.DAO.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackListService {

    Conexao DAO = new Conexao();
    Scanner leia = new Scanner(System.in);

    public Object bloqueadarUsuario() throws SQLException {
        Connection conexao = CriarConexao.getConnetion();
        System.out.println("DIGITE O ID DO USUARIO PARA CONSULTAR");
        String nomeUsuarioId = leia.nextLine();
        String nome = "";
        String nome_do_meio = "";
        String ultimo_nome = "";
        String token = "";
        String bloqueado_por = "ADM";
        String desbloqueado_por = "";
        String dia = "hoje";
        String hora = "agora";

        String sql = "SELECT * FROM moradores.tbl_consultas tc WHERE TOKEN = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1,nomeUsuarioId);
        ResultSet rs = statement.executeQuery();

        List<String> listaDeUsuariosAtivos = new ArrayList<>();
        while (rs.next()) {
             nome = rs.getString("nome");
             nome_do_meio = rs.getString("nome_do_meio");
             ultimo_nome = rs.getString("ultimo_nome");
             token = rs.getString("token");

            listaDeUsuariosAtivos.add(nome);
            listaDeUsuariosAtivos.add(nome_do_meio);
            listaDeUsuariosAtivos.add(ultimo_nome);
            listaDeUsuariosAtivos.add(token);
        }

        for (String listaUsuario : listaDeUsuariosAtivos) {
            System.out.println(listaUsuario);
        }
        System.out.println("Gostaria de bloquear este ID: S|N");
        String respostaUsuario = leia.nextLine();
        if (respostaUsuario.equalsIgnoreCase("S")){
            String sqlBloqueado = "INSERT INTO moradores.lista_negra (nome, sobrenome, ultimo_nome, bloqueado_por, token, desbloqueado_por, dia, hora) values (?,?,?,?,?,?,?,?)";
            DAO.incluir(sqlBloqueado, nome, nome_do_meio, ultimo_nome, bloqueado_por, token, desbloqueado_por, dia, hora);
            System.out.println("USUARIO BLOQUEADO");
        }else{
            System.out.println("Operação cancelada");
        }
        return true;
    }

    public Object removeDaListaNegra(){
        System.out.println("REMOVER USUARIO DA LISTA DE BLOQUEADOS");
        String removeLinha = leia.nextLine();
        String sqlRemoveUsuario = "DELETE from moradores.lista_negra WHERE token = ?";
        DAO.incluir(sqlRemoveUsuario,removeLinha);

        return true;
    }

    public static void main(String[] args) throws SQLException {
        BlackListService service = new BlackListService();
        service.removeDaListaNegra();
    }
}