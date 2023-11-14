package BootTelegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;



public class Respostas {
    public SendMessage enviaMensagem(Update update) {
        var textoMensagem = update.getMessage();
        var user = update.getMessage().getChatId();

        var resposta = "";
        if (textoMensagem.getText().startsWith("oi")) {
            resposta = "Estou sem funcionalidade ...Peladinho da Silva";
        }
        if (textoMensagem.getText().startsWith("como esta a apreendizagem ")) {
            resposta = "Estou empenhado em aprender sua linguagem de programação, cada dia um novo aprendizado .. bip bip";
        } else {
            resposta = "Ainda não entendo o que isso significa.. mas estou estudando muito pra poder entender sua" +
                    " linguagem de programação e assim conversamos muito";
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(user.toString())
                .build();


    }
}

