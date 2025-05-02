package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Service.AcessoHistoricoService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;


public class Respostas {
    IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
    AcessoHistoricoService acessoHistoricoService = new AcessoHistoricoService();

    public SendMessage enviaMensagem(Update update) throws SQLException, ClassNotFoundException {
        var textoMensagem = update.getMessage();
        var teste = update.hasChatMember();
        var user = update.getMessage().getChatId();
        var resposta = "";

        if (teste) {
            resposta = RespostaApiEnum.TESTE.getDescricao();
        } else if (textoMensagem.getText().startsWith("Sophia")) {
            resposta = RespostaApiEnum.SOPHIA.getDescricao();
            // PEGA VALOR SALVO
        } else if (textoMensagem.getText().startsWith("token")) {
            resposta = incluiTokenRepository.enviaToken();
        } else if (textoMensagem.getText().equalsIgnoreCase("historico anterior")) {
            resposta = String.valueOf(acessoHistoricoService.historicoMesAnterior());
        } else if (textoMensagem.getText().equalsIgnoreCase("historico anterior completo")) {
            resposta = String.valueOf(acessoHistoricoService.historicoMesAnteriorCompleto());
        } else if (textoMensagem.getText().equalsIgnoreCase("historico")) {
            resposta = String.valueOf(acessoHistoricoService.historicoHoje());
        } else if (textoMensagem.getText().equalsIgnoreCase("historico completo")) {
            resposta = String.valueOf(acessoHistoricoService.historicoHojeCompleto());
        } else if (textoMensagem.getText().equalsIgnoreCase("menu")) {
            resposta = String.valueOf(acessoHistoricoService.menuCelular());
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