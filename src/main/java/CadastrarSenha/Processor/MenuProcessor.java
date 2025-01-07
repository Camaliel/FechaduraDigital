package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Repository.Login.ConsultasRepository;
import CadastrarSenha.View.Menu;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.util.Scanner;

import static CadastrarSenha.View.Menu.valor;


public class MenuProcessor {

    TelaBot bot = new TelaBot();
    ConsultasRepository consultaRepository = new ConsultasRepository();
    Scanner leia = new Scanner(System.in);

    public int valorRecebidoDigitado;

    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    public String menuPrincipal() throws TelegramApiException, SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        System.out.println("Escolha uma opção");
        bot.ligarApi(); // TODO QUEBRADO NÃO FECHA
        System.out.println("1-Cadastrar | 2-Login");
        int valorOpcao = leia.nextInt();

        valorRecebidoDigitado = valorOpcao;

        switch (valorOpcao) {
            case 1:
                menu.menuParente(valor);
                break;
            case 2:
                consultaRepository.pesquisaNaListaDeUsuarios();
                break;
            default:
                menuValorInvalido();
                break;
        }
        leia.close();
        return "fechado";
    }


    public void menuValorInvalido() throws TelegramApiException, SQLException, ClassNotFoundException {
        MenuProcessor menuProcessor = new MenuProcessor();
        while (valorRecebidoDigitado > 2) {
            System.out.println(MensagemEnum.ADICIONE_OPCAO_VALIDA.getDescricao());;
            menuProcessor.menuPrincipal();
        }
    }

    public static void main(String[] args) throws TelegramApiException, SQLException, ClassNotFoundException {
        MenuProcessor teste = new MenuProcessor();
        teste.menuPrincipal();
    }
}

