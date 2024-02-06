package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

public class TelaBot {

    SenhaService senhaService = new SenhaService();
    InfoUsuario usuario = new InfoUsuario();
    String senhaGravada = usuario.getSenha();
    ConfereChaveToken confereChaveToken = new ConfereChaveToken();
    IncluiToken incluiToken =  new IncluiToken();

    NumeroCelularService service = new NumeroCelularService();

    String numeroCelularValido = usuario.getNumeroCelular();
    public void ligarApi() throws TelegramApiException, SQLException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        EcoBot bot = new EcoBot();
        telegramBotsApi.registerBot(new EcoBot());
        System.out.println("LIGADO");

        incluiToken.incluiToken();
        confereChaveToken.validaChaveToken();
//        System.out.println("enviando informação ao banco");
//        service.adicionaNumero(numeroCelularValido);
    }

}
