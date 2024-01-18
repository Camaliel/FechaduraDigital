package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

public class TelaBot {
    public static void main(String[] args) throws TelegramApiException, SQLException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        EcoBot bot = new EcoBot();
        telegramBotsApi.registerBot(new EcoBot());
        System.out.println("LIGADO");
        IncluiToken incluiToken =  new IncluiToken();
        incluiToken.incluiToken();
    }
}
