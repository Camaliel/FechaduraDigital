package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

public class TelaBot {

    public void ligarApi() throws Throwable {
           TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
           telegramBotsApi.registerBot(new EcoBot());
           System.out.println("LIGADO");
    }
}