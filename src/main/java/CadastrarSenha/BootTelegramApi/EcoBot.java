package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

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
            SendMessage mensagem = null;
            try {
                mensagem = responder(update);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) throws SQLException, ClassNotFoundException {
        Respostas respostas = new Respostas();
        respostas.enviaMensagem(update);

        return respostas.enviaMensagem(update);
    }

}

