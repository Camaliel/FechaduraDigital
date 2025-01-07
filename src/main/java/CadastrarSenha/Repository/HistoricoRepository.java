package CadastrarSenha.Repository;

import CadastrarSenha.Util.Variavel.VariaveisHistorico;
import CadastrarSenha.jdbc.DAO.Conexao;
import CadastrarSenha.jdbc.EnviaToken;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.*;

public class HistoricoRepository {
    Conexao DAO = new Conexao();
    Date data = new Date();
    EnviaToken token = new EnviaToken();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");

    public void enviaHistorico( String numeroToken, String primeiroNome, String nomeDoMEio, String ultimoNOme, String data, String hora, String parentesco, String status) throws SQLException {
        VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
        String dataSistema = dataAtual.format(this.data);
        variaveisHistorico.setData(dataSistema);
        String horaSistema = horaAtual.format(this.data);
        variaveisHistorico.setHora(horaSistema);
        String nome = nomeArmazenadoPai;
        String nomeDoMeio = nomeDoMeioArmazenadoPai;
        String ultimoNome = sobrenomeArmazenadoPai;
        String token = this.token.enviaToken();
        // RECEBE DOIS PARAMETROS E ENVIA PARA O BANCO DEPENDENDO DO RESULTADO .. À ENTENDER ...
        String sql = "INSERT INTO moradores.historico (TOKEN, NOME, NOME_DO_MEIO, ULTIMO_NOME, DATA, HORA, PARENTESCO, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        DAO.incluir(sql,token, nome, nomeDoMeio,ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, status);
    }

    public static void main(String[] args) throws SQLException {
        HistoricoRepository historicoRepository = new HistoricoRepository();
//        historicoRepository.enviaHistorico("AMANTE2","PENDENTE", nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Liberada");
    }
}