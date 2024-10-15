package CadastrarSenha.Repository;

import CadastrarSenha.Entities.HistoricoEntity;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HistoricoRepository {
    Conexao DAO = new Conexao();
    HistoricoEntity entity = new HistoricoEntity();
    Scanner leia = new Scanner(System.in);
    ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
    Date data = new Date();
    SimpleDateFormat dataAtual = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");


    public void enviaHistorico(String parentesco, String status) {
        String dataSistema = dataAtual.format(data);
        String horaSistema = horaAtual.format(data);
        // RECEBE DOIS PARAMETROS E ENVIA PARA O BANCO DEPENDENDO DO RESULTADO .. À ENTENDER ...
        String sql = "INSERT INTO HISTORICO(DATA, HORA, PARENTESCO, STATUS) VALUES(?, ?, ?, ?)";
        DAO.incluir(sql, dataSistema, horaSistema, parentesco, status);
    }

    public static void main(String[] args) {
        HistoricoRepository historicoRepository = new HistoricoRepository();
        historicoRepository.enviaHistorico("AMANTE2","PENDENTE");
    }
}