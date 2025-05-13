package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Entities.GuardaTokenEntity;
import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Service.AcessoHistoricoService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;


public class Respostas {
    IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
    AcessoHistoricoService acessoHistoricoService = new AcessoHistoricoService();
    GuardaTokenEntity entity = new GuardaTokenEntity();

    String textoDigitadoPeloUsuario = TokenDigitado.insereValor;
    String testandoValorDoCelularDigitado = AcessoHistoricoService.testandoValorCelular;
    static boolean usuarioNoMenu = false;
    String valorDigitadoHistorico = "";


    public SendMessage enviaMensagem(Update update) throws SQLException, ClassNotFoundException {
        var textoMensagem = update.getMessage();
        var teste = update.hasChatMember();
        var user = update.getMessage().getChatId();
        var resposta = "";
        // Para saber se o usuário está dentro do menu





        if (!textoDigitadoPeloUsuario.isEmpty() && textoMensagem.getText().equalsIgnoreCase(textoDigitadoPeloUsuario)) {
            resposta = "Acesso ao menu\n" +
                    "\"Escolha uma Opção | 1 historico hoje | 2 Historico anterior | 3 Historico Anterior Completo |" +
                    " 4 historico Hoje Completo ...\"";

            usuarioNoMenu = true;

        } else if (usuarioNoMenu) {
            String escolhaMenuHistorico = textoMensagem.getText();

            if (escolhaMenuHistorico.equalsIgnoreCase("1")) {
                resposta = String.valueOf(acessoHistoricoService.historicoHoje());

            } else if (escolhaMenuHistorico.equalsIgnoreCase("2")) {
                resposta = String.valueOf(acessoHistoricoService.historicoMesAnterior());

            } else if (escolhaMenuHistorico.equalsIgnoreCase("3")) {
                resposta = String.valueOf(acessoHistoricoService.historicoMesAnteriorCompleto());

//        } else if (textoMensagem.getText().equalsIgnoreCase("historico")) {
//            resposta = String.valueOf(acessoHistoricoService.historicoHoje());

            } else if (escolhaMenuHistorico.equalsIgnoreCase("4")) {
                resposta = String.valueOf(acessoHistoricoService.historicoHojeCompleto());
            } else if (escolhaMenuHistorico.equalsIgnoreCase("sair")) {
                usuarioNoMenu = false;
            }


        } else if (textoMensagem.getText().startsWith("Sophia")) {
            resposta = RespostaApiEnum.SOPHIA.getDescricao();

            // PEGA VALOR SALVO
        } else if (textoMensagem.getText().startsWith("token")) {
            resposta = incluiTokenRepository.enviaToken();

        } else if (textoMensagem.getText().equalsIgnoreCase("menu")) {
            resposta = String.valueOf(acessoHistoricoService.menuCelular());
// ------------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------------

        } else if (textoMensagem.getText().startsWith("mudar senha")) {
            // Atualiza o token com base no que o usuário digitou no Telegram
            String tokenDigitado = textoMensagem.getText().replaceFirst("mudar senha", "").trim();
            TokenDigitado.insereValor = tokenDigitado;
            resposta = "Token atualizado para: " + tokenDigitado;


        } else if (textoMensagem.getText().startsWith("Estudando muito?")) {
            resposta = RespostaApiEnum.NAO_ENTENDO_SUA_LINGUAGEM_DE_PROGRAMACAO.getDescricao();

            /// USANDO PARA TESTE

        } else {
            resposta = "...";
        }


        return SendMessage.builder()
                .text(resposta)
                .chatId(user.toString())
                .build();

    }


}