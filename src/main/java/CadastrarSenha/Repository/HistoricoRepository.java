package CadastrarSenha.Repository;

import CadastrarSenha.jdbc.DAO.Conexao;

import java.text.SimpleDateFormat;
import java.util.Date;

import static CadastrarSenha.Service.CpfService.cpfDigitado;

public class HistoricoRepository {
    Conexao DAO = new Conexao();
    ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
    Date data = new Date();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");

    public void enviaHistorico(String parentesco, String status) {
        String dataSistema = dataAtual.format(data);
        String horaSistema = horaAtual.format(data);
        String cpf = cpfDigitado;
        // RECEBE DOIS PARAMETROS E ENVIA PARA O BANCO DEPENDENDO DO RESULTADO .. À ENTENDER ...
        String sql = "INSERT INTO moradores.historico (CPF,DATA, HORA, PARENTESCO, STATUS) VALUES(?, ?, ?, ?, ?)";
        DAO.incluir(sql, cpf, dataSistema, horaSistema, parentesco, status);
    }

    public static void main(String[] args) {
        HistoricoRepository historicoRepository = new HistoricoRepository();
        historicoRepository.enviaHistorico("AMANTE2","PENDENTE");
    }
}