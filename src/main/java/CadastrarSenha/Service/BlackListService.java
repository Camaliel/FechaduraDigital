package CadastrarSenha.Service;

import CadastrarSenha.Entities.HistoricoEntity;
import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Repository.HistoricoRepository;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BlackListService {

    Conexao DAO = new Conexao();
    Scanner leia = new Scanner(System.in);
    HistoricoRepository repository = new HistoricoRepository();
    VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
    Date data = new Date();
    IncluiTokenRepository token = new IncluiTokenRepository();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");

    public Object bloquearUsuario() throws SQLException {
        HistoricoEntity entity = new HistoricoEntity();
        Connection conexao = CriarConexao.getConnetion();
        VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
        String dataSistema = dataAtual.format(this.data);
        variaveisHistorico.setData(dataSistema);
        String horaSistema = horaAtual.format(this.data);
        variaveisHistorico.setHora(horaSistema);
        System.out.println("DIGITE O ID DO USUARIO PARA CONSULTAR");
        String nomeUsuarioId = leia.nextLine();
        String nome = "";
        String nome_do_meio = "";
        String ultimo_nome = "";
        String token = nomeUsuarioId;
        String bloqueado_por = "ADM";
        String desbloqueado_por = "";
        String dia = "hoje";
        String hora = "agora";
        String parente = "";

        String sql = "SELECT * FROM MORADORES.HISTORICO tc WHERE TOKEN = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, nomeUsuarioId);
        ResultSet rs = statement.executeQuery();


        List<String> listaDeUsuariosAtivos = new ArrayList<>();
        while (rs.next()) {
             nome = rs.getString("NOME");
             nome_do_meio = rs.getString("NOME_DO_MEIO");
             ultimo_nome = rs.getString("ULTIMO_NOME");
            token = rs.getString("TOKEN");
            parente = rs.getString("PARENTESCO");


            nome = String.valueOf(listaDeUsuariosAtivos.add(nome));
            nome_do_meio = String.valueOf(listaDeUsuariosAtivos.add(nome_do_meio));
            ultimo_nome = String.valueOf(listaDeUsuariosAtivos.add(ultimo_nome));
            listaDeUsuariosAtivos.add(token);
            listaDeUsuariosAtivos.add(parente);
        }

        for (String listaUsuario : listaDeUsuariosAtivos) {
            System.out.println(listaUsuario);
        }
        System.out.println("Gostaria de bloquear este ID: S|N");
        String respostaUsuario = leia.nextLine();
        if (respostaUsuario.equalsIgnoreCase("S")) {
            String sqlBloqueado = "INSERT INTO MORADORES.LISTA_NEGRA (NOME, SOBRENOME, ULTIMO_NOME, BLOQUEADO_POR, TOKEN, " +
                    "DESBLOQUEADO_POR, DATA, HORA) values (?,?,?,?,?,?,?,?)";

            DAO.incluir(sqlBloqueado, nome, nome_do_meio, ultimo_nome, bloqueado_por, token, desbloqueado_por, dia, hora);
            System.out.println("USUARIO BLOQUEADO");

            repository.enviaHistorico(token, nome, nome_do_meio, ultimo_nome, dia, hora, parente, "Bloqueado");
        } else {
            System.out.println("Operação cancelada");
        }
        return true;
    }

    public Object removeDaListaNegra() throws SQLException {
        VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
        String dataSistema = dataAtual.format(this.data);
        variaveisHistorico.setData(dataSistema);
        String horaSistema = horaAtual.format(this.data);
        variaveisHistorico.setHora(horaSistema);
        System.out.println("DIGITE O ID DO USUARIO PARA CONSULTAR");
        String nomeUsuarioId = leia.nextLine();
        String nome = "";
        String nome_do_meio = "";
        String ultimo_nome = "";
        String token = nomeUsuarioId;
        String dia = "hoje";
        String hora = "agora";
        String parente = "";
        System.out.println("REMOVER USUARIO DA LISTA DE BLOQUEADOS");
        String removeLinha = leia.nextLine();
        String sqlRemoveUsuario = "DELETE from MORADORES.LISTA_NEGRA WHERE token = ?";
        DAO.incluir(sqlRemoveUsuario, removeLinha);
        repository.enviaHistorico(token, nome, nome_do_meio, ultimo_nome, dia, hora, parente, "Desbl");

        return true;
    }

    public static void main(String[] args) throws SQLException {
        BlackListService service = new BlackListService();
        service.bloquearUsuario();
//        service.removeDaListaNegra();
    }
}