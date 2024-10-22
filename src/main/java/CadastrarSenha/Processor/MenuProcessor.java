package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import CadastrarSenha.Repository.Login.ConsultasRepository;
import CadastrarSenha.Util.Menu;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static CadastrarSenha.Repository.Login.ConsultasRepository.consultaParentesco;
import static CadastrarSenha.Repository.Login.ConsultasRepository.status;
import static CadastrarSenha.Util.Menu.valor;


public class MenuProcessor {

    ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
    TelaBot bot = new TelaBot();
    ConfereChaveToken chaveToken = new ConfereChaveToken();
    IncluiToken incluiToken = new IncluiToken();
    ConsultasRepository consultaRepository = new ConsultasRepository();
    Scanner leia = new Scanner(System.in);

    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    //TODO LEMBRETE: DEIXAR PADRAO E MAIS LIMPO COMO O MENNU 3

    public static String valorSelecionado = "";

    public void menuPrincipal() throws TelegramApiException, SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        //todo fazer de novo instanciar as classes


        System.out.println("Escolha uma opção");
        System.out.println("1-Cadastrar | 2-Login");
        int valorOpcao = leia.nextInt();
        try {
            switch (valorOpcao) {

                case 1:
                    bot.ligarApi(); // TODO QUEBRADO NÃO FECHA
                    menu.menuParente(valor);
                    break;
                case 2:
                    consultaRepository.pesquisaNaListaDeUsuarios();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Se fudeu");
        }
    }

//        voltarMenu();

//
//    public void voltarMenu() throws SQLException, TelegramApiException, ClassNotFoundException {
//        System.out.println("Deseja voltar ao menu principal ? ");
//        String textoUsuario = leia.nextLine();
//
//        while (leia.hasNext() && textoUsuario.equalsIgnoreCase("sim")) {
//            menuPrincipal();
//        }
//    }


    public static void main(String[] args) throws TelegramApiException, SQLException, ClassNotFoundException {
        MenuProcessor menuProcessor = new MenuProcessor();
        menuProcessor.menuPrincipal();

    }
}
