package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

public class TelaBot {

    public void ligarApi() throws TelegramApiException, SQLException {
           TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
           EcoBot bot = new EcoBot();
           telegramBotsApi.registerBot(new EcoBot());
           System.out.println("LIGADO");


    }

}
