package Tela;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Processor.MenuProcessor;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Repository.ConfereChaveTokenRepository;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Repository.Login.ConsultasRepository;
import CadastrarSenha.Repository.Login.LoginRepository;
import CadastrarSenha.Service.*;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Instanciação das dependências
        Scanner leia = new Scanner(System.in);
        TelaBot bot = new TelaBot();
        ConsultasRepository consultaRepository = new ConsultasRepository();
        LoginRepository loginRepository = new LoginRepository();
        Conexao conexao = new Conexao();
        IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
        GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();
        ConfereChaveTokenRepository confereChaveTokenRepository = new ConfereChaveTokenRepository(incluiTokenRepository, geradorDeChaveTokenService);
        VariaveisHistorico variaveisHistorico = new VariaveisHistorico();
        CpfService cpfService = new CpfService();
        NumeroCelularService celularService = new NumeroCelularService();
        SenhaService senhaService = new SenhaService();

        // Criação do ArmazenaInformacaoPessoaRepository com injeção de dependências
        ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository(conexao,
                incluiTokenRepository, geradorDeChaveTokenService, confereChaveTokenRepository, variaveisHistorico
        );

        FamiliarService familiarService = new FamiliarService(repository, celularService,senhaService,cpfService,leia);

        // Criação do MenuProcessor com injeção de dependências
        MenuProcessor process = new MenuProcessor(bot, consultaRepository, loginRepository, leia,
                familiarService, repository, cpfService
        );

        // Execução do menu principal
        process.menuPrincipal();

        // Fechamento do scanner após o uso
        leia.close();
    }
}