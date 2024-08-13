package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import CadastrarSenha.Service.ChaveToken;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;


public class Respostas {
    ChaveToken chaveToken = new ChaveToken();
    NumeroSalvo lembra = new NumeroSalvo();
    IncluiToken incluiToken = new IncluiToken();


    ConfereChaveToken confereChaveToken = new ConfereChaveToken();

    public SendMessage enviaMensagem(Update update) throws SQLException, ClassNotFoundException {
        var textoMensagem = update.getMessage();
        var user = update.getMessage().getChatId();

        var resposta = "";
        if (textoMensagem.getText().startsWith("oi")) {
            resposta = RespostaApiEnum.SEM_FUNCIONALIDADE.getDescricao();
        } else if (textoMensagem.getText().startsWith("Sophia")) {
            resposta = RespostaApiEnum.SOPHIA.getDescricao();
            // PEGA VALOR SALVO
        } else if (textoMensagem.getText().startsWith("Token")) {
            resposta = incluiToken.incluiToken();
        } else if (textoMensagem.getText().startsWith("teste")) {
            resposta = RespostaApiEnum.TESTE_BOT.getDescricao();
        } else if (textoMensagem.getText().startsWith("Estudando muito?")) {
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