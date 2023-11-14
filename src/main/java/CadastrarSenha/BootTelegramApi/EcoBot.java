package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static CadastrarSenha.BootTelegramApi.DadosBot.BOT_TOKEN;
import static CadastrarSenha.BootTelegramApi.DadosBot.BOT_USER_NAME;

public class EcoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) {
        Respostas respostas = new Respostas();
        respostas.enviaMensagem(update);

        return respostas.enviaMensagem(update);
    }

}

