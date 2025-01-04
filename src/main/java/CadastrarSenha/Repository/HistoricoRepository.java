package CadastrarSenha.Repository;

import CadastrarSenha.jdbc.DAO.Conexao;
import CadastrarSenha.jdbc.EnviaToken;

import javax.mail.internet.HeaderTokenizer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.FamiliarService.confirmaPatriarca;
import static CadastrarSenha.Util.Menu.*;

public class HistoricoRepository {
    Conexao DAO = new Conexao();
    Date data = new Date();
    EnviaToken token = new EnviaToken();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");

    public void enviaHistorico(String parentesco, String status) throws SQLException {
        String dataSistema = dataAtual.format(data);
        String horaSistema = horaAtual.format(data);
        String nome = nomeArmazenadoPai;
        String nomeDoMeio = nomeDoMeioArmazenadoPai;
        String ultimoNome = sobrenomeArmazenadoPai;
        String chefe_familia = confirmaPatriarca;
        String token = this.token.enviaToken();
        // RECEBE DOIS PARAMETROS E ENVIA PARA O BANCO DEPENDENDO DO RESULTADO .. À ENTENDER ...
        String sql = "INSERT INTO moradores.historico (TOKEN, NOME, NOME_DO_MEIO, ULTIMO_NOME, DATA, HORA, PARENTESCO, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        DAO.incluir(sql,token, nome, nomeDoMeio,ultimoNome, dataSistema, horaSistema, parentesco, status);
    }

    public static void main(String[] args) throws SQLException {
        HistoricoRepository historicoRepository = new HistoricoRepository();
        historicoRepository.enviaHistorico("AMANTE2","PENDENTE");
    }
}