package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Enum.RespostaApiEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Respostas {
    TokenUsuario token = new TokenUsuario();
    NumeroSalvo lembra = new NumeroSalvo();
    public SendMessage enviaMensagem(Update update) {
        var textoMensagem = update.getMessage();
        var user = update.getMessage().getChatId();

        var resposta = "";
        if (textoMensagem.getText().startsWith("oi")) {
            resposta = RespostaApiEnum.SEM_FUNCIONALIDADE.getDescricao();
        } else if (textoMensagem.getText().startsWith("como vai")) {
            resposta = RespostaApiEnum.APRENDENDO.getDescricao();
        } else if (textoMensagem.getText().startsWith("Numero")) {
            resposta = String.valueOf(token.numeroAleatorio(update));
        } else if (textoMensagem.getText().startsWith("lembra")) {
            resposta = token.lembraNumeroSalvo();
        } else if (textoMensagem.getText().startsWith("teste")) {
            resposta = RespostaApiEnum.TESTE_BOT.getDescricao();
        } else if (textoMensagem.getText().startsWith("estudando muito ?")) {
            resposta = RespostaApiEnum.NAO_ENTENDO_SUA_LINGUAGEM_DE_PROGRAMACAO.getDescricao();


    } else {
            resposta = RespostaApiEnum.NAO_ENTENDO_SUA_LINGUAGEM_DE_PROGRAMACAO.getDescricao();
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(user.toString())
                .build();


    }

}

