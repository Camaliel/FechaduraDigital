package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Repository.Login.ConsultasRepository;
import CadastrarSenha.Repository.Login.LoginRepository;
import CadastrarSenha.View.Menu;

import java.util.Scanner;

import static CadastrarSenha.View.Menu.valor;

public class MenuProcessor {

    TelaBot bot = new TelaBot();
    ConsultasRepository consultaRepository = new ConsultasRepository();
    LoginRepository loginRepository = new LoginRepository();
    Scanner leia = new Scanner(System.in);

    public int valorRecebidoDigitado;

    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    public void menuPrincipal() throws Throwable {
        Menu menu = new Menu();
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
        MenuProcessor menuProcessor = new MenuProcessor();
        while (valorRecebidoDigitado > 2) {
            System.out.println(MensagemEnum.ADICIONE_OPCAO_VALIDA.getDescricao());;
            menuProcessor.menuPrincipal();
        }
    }

    public static void fimDoPrograma(){
        /*
        * Força a JVM a fechar de maneira bem sucedida.
        * */
        System.exit(0);
    }
    public static void main(String[] args) throws Throwable {
        MenuProcessor teste = new MenuProcessor();
        teste.menuPrincipal();
    }
}