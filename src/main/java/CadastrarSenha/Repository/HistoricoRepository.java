package CadastrarSenha.Repository;

import CadastrarSenha.Jdbc.CriarConexao;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;
import CadastrarSenha.Jdbc.DAO.Conexao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class HistoricoRepository {
    Conexao DAO = new Conexao();
    Date data = new Date();
    IncluiTokenRepository token = new IncluiTokenRepository();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");

    public void enviaHistorico(String numeroToken, String primeiroNome, String nomeDoMEio, String ultimoNOme, String data, String hora, String parentesco, String status) throws SQLException {
        VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
        String dataSistema = dataAtual.format(this.data);
        variaveisHistorico.setData(dataSistema);
        String horaSistema = horaAtual.format(this.data);
        variaveisHistorico.setHora(horaSistema);
//        String nome = primeiroNome;
//        String nomeDoMeio = nomeDoMEio;
//        String ultimoNome = ultimoNOme;
        String token = numeroToken;

        // RECEBE DOIS PARAMETROS E ENVIA PARA O BANCO DEPENDENDO DO RESULTADO .. À ENTENDER ...

        String sql = "INSERT INTO MORADORES.HISTORICO (TOKEN, NOME, NOME_DO_MEIO, ULTIMO_NOME, DATA, HORA, PARENTESCO, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        DAO.incluir(sql, token, primeiroNome, nomeDoMEio, ultimoNOme, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, status);
    }
}