package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Repository.Login.ConsultasRepository;
import CadastrarSenha.Repository.Login.LoginRepository;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.View.Menu;

import java.util.Scanner;

import static CadastrarSenha.View.Menu.valor;

public class MenuProcessor {

    private final TelaBot bot;
    private final ConsultasRepository consultaRepository;
    private final LoginRepository loginRepository;
    private final Scanner leia;
    private final FamiliarService familiarService;
    private final ArmazenaInformacaoPessoaRepository repository;
    private final CpfService cpfService;

    // Construtor com injeção de dependências
    public MenuProcessor(TelaBot bot, ConsultasRepository consultaRepository, LoginRepository loginRepository,
                         Scanner leia, FamiliarService familiarService, ArmazenaInformacaoPessoaRepository repository,
                         CpfService cpfService) {
        this.bot = bot;
        this.consultaRepository = consultaRepository;
        this.loginRepository = loginRepository;
        this.leia = leia;
        this.familiarService = familiarService;
        this.repository = repository;
        this.cpfService = cpfService;
    }

    public int valorRecebidoDigitado;

    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    public void menuPrincipal() throws Throwable {

        Menu menu = new Menu(familiarService, repository, cpfService);
        System.out.println("Escolha uma opção");
        bot.ligarApi();
        System.out.println("1-Cadastrar | 2-Login [Perdi a senha] | 3-Login Direto");
        int valorOpcao = leia.nextInt();

        valorRecebidoDigitado = valorOpcao;

        switch (valorOpcao) {
            case 1:
                menu.menuParente(valor);
                break;
            case 2:
                consultaRepository.pesquisaNaListaDeUsuarios();
                break;
            case 3:
                loginRepository.acessoLogin();
                break;
            default:
                menuValorInvalido();
                break;
        }
        leia.close();
        fimDoPrograma();
    }

    private void menuValorInvalido() throws Throwable {
        MenuProcessor menuProcessor = new MenuProcessor(bot, consultaRepository, loginRepository, leia, familiarService, repository, cpfService);

        while (valorRecebidoDigitado > 2) {
            System.out.println(MensagemEnum.ADICIONE_OPCAO_VALIDA.getDescricao());
            menuProcessor.menuPrincipal();
        }
    }

    public static void fimDoPrograma() {
        /*
         * Força a JVM a fechar de maneira bem sucedida.
         * */
        System.exit(0);
    }
}