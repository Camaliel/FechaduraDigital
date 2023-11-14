package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class RegistrarBot {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        EcoBot bot = new EcoBot();
        telegramBotsApi.registerBot(new EcoBot());
        System.out.println("LIGADO");
    }
}
