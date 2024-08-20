package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Repository.*;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.ValoresDigitados;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.EnviaToken;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuProcessor {

    ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
    TelaBot bot = new TelaBot();
    ConfereChaveToken chaveToken = new ConfereChaveToken();
    IncluiToken incluiToken = new IncluiToken();



    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    //TODO LEMBRETE: DEIXAR PADRAO E MAIS LIMPO COMO O MENNU 3

    public void menuPrincipal() throws TelegramApiException, SQLException, ClassNotFoundException {
        //todo fazer de novo instanciar as classes

        bot.ligarApi();
        repository.logicaPersistencia();
//        voltarMenu();

    }

    public void voltarMenu() throws SQLException, TelegramApiException, ClassNotFoundException {
        Scanner leia = new Scanner(System.in);

        System.out.println("Deseja voltar ao menu principal ? ");
        String textoUsuario = leia.nextLine();
            while (textoUsuario.equalsIgnoreCase("sim") || textoUsuario.equalsIgnoreCase("S")) {
             menuPrincipal();

            }
        }
        public void pare(){

        }
        public static void main (String[]args) throws TelegramApiException, SQLException, ClassNotFoundException {
            MenuProcessor menu = new MenuProcessor();
            menu.menuPrincipal();

        }
    }
