package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Entities.GuardaTokenEntity;
import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Service.AcessoHistoricoService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;

import static CadastrarSenha.BootTelegramApi.TokenDigitado.insereValor;
import static CadastrarSenha.BootTelegramApi.TokenDigitado.valorRetornadoComSucesso;


public class Respostas {
    IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
    AcessoHistoricoService acessoHistoricoService = new AcessoHistoricoService();
    GuardaTokenEntity entity = new GuardaTokenEntity();

    String textoDigitadoPeloUsuario = insereValor;
    String testandoValorDoCelularDigitado = AcessoHistoricoService.testandoValorCelular;
    static boolean usuarioNoMenu = false;
    String valorDigitadoHistorico = "";


    public SendMessage enviaMensagem(Update update) throws SQLException, ClassNotFoundException {
        var textoMensagem = update.getMessage();
        var teste = update.hasChatMember();
        var user = update.getMessage().getChatId();
        var resposta = "";
        // Para saber se o usuário está dentro do menu


        if (textoMensagem.getText().equalsIgnoreCase("oi")) {
            resposta = "Fala viado se vc é um ADMIN digita seu token pra gente já começa a bloquear uns doido ai";
        } else if (!textoDigitadoPeloUsuario.isEmpty() && textoMensagem.getText().equalsIgnoreCase(textoDigitadoPeloUsuario)) {
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

        } else if (textoMensagem.getText().startsWith("senha")) {
            TokenDigitado tokenDigitado = new TokenDigitado();
            insereValor = textoMensagem.getText().replaceFirst("senha", "").trim();
            if (insereValor.contains(tokenDigitado.tokenDigitadoTelegram().toString())){
                resposta = valorRetornadoComSucesso;
            }else{
                resposta = "Valor nao encontrado";
            }
            // Atualiza o token com base no que o usuário digitou no Telegram

        } else if (textoMensagem.getText().startsWith("mudar senha")) {
            String tokenDigitado = textoMensagem.getText().replaceFirst("mudar senha", "").trim();
            insereValor = tokenDigitado;
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