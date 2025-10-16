package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Enum.RespostaApiEnum;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Repository.HistoricoRepository;
import CadastrarSenha.Repository.IncluiTokenRepository;
import CadastrarSenha.Service.AcessoHistoricoService;
import CadastrarSenha.Service.BlackListService;
import CadastrarSenha.Service.VariaveisService.VariaveisBloqueioService;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static CadastrarSenha.BootTelegramApi.TokenDigitado.insereValor;


public class Respostas {
    IncluiTokenRepository incluiTokenRepository = new IncluiTokenRepository();
    AcessoHistoricoService acessoHistoricoService = new AcessoHistoricoService();

    public static boolean respostaTodos = false;
    static boolean usuarioNoMenu = false;
    public static String tokenDigitadoPeloUsuario;


    public SendMessage enviaMensagem(Update update) throws SQLException, ClassNotFoundException {
        var textoMensagem = update.getMessage();
        var teste = update.hasChatMember();
        var user = update.getMessage().getChatId();
        var resposta = "";
        // Para saber se o usuário está dentro do menu

        if (textoMensagem.getText().equalsIgnoreCase("oi")) {
            resposta = "Fala viado se vc é um ADMIN digita seu token pra gente já começa a bloquear uns doido ai";
        } else if (textoMensagem.getText().startsWith("senha")) {
            TokenDigitado tokenDigitado = new TokenDigitado();
            insereValor = textoMensagem.getText().replaceFirst("senha", "").trim();
            if (insereValor.contains(tokenDigitado.tokenDigitadoTelegram())) {
                resposta = "Acesso ao menu\n" +
                        "\"Escolha uma Opção | 1 historico hoje | 2 Historico anterior | 3 Historico Anterior Completo |" +
                        " 4 historico Hoje Completo ...\"";
                ;
                usuarioNoMenu = true;
            } else {
                resposta = "Token ADMIN não econtrado !";
            }

        } else if (usuarioNoMenu) {
            String escolhaMenuHistorico = textoMensagem.getText();
            String valorDigitadoPeloUsuarioTelegram = "";

            if (escolhaMenuHistorico.equalsIgnoreCase("1")) {
                resposta = String.valueOf(acessoHistoricoService.historicoHoje()) + "\n" +
                        "1.1 - Bloquear Usuario | 2.2 - Nota | 3.3 - Favoritar ";

                // Construção da interação do usuario com o programa pelo telegram

            } else if (escolhaMenuHistorico.equalsIgnoreCase("1.1")) {
                resposta = "Digite [TODOS] para ver lista de usuarios para bloqueio:";
//                bloquear = true;

//                todo Parei aqui
//            }else if(){

            } else if (textoMensagem.getText().startsWith("todos")) {  // <- O problema esta aqui
                respostaTodos = true;
                BlackListService service = new BlackListService();
                String tokenDigitado = textoMensagem.getText().replaceFirst("todos", "").trim();
                tokenDigitadoPeloUsuario = tokenDigitado;
                resposta = service.bloquearUsuario().toString();
                respostaTodos = false;
            }
            if (textoMensagem.getText().startsWith("bloquear")) {  // <- O problema esta aqui
                respostaTodos = true;
                BlackListService service = new BlackListService();
                String tokenDigitado1 = textoMensagem.getText().replaceFirst("bloquear", "").trim();
                tokenDigitadoPeloUsuario = tokenDigitado1;
                resposta = service.bloquearUsuario().toString();
                respostaTodos = false;

            } else if (escolhaMenuHistorico.equalsIgnoreCase("2")) {
                resposta = String.valueOf(acessoHistoricoService.historicoMesAnterior()) + "\n" +
                        "1.1 - Bloquear Usuario | 2.2 - Nota | 3.3 - Favoritar ";

            } else if (escolhaMenuHistorico.equalsIgnoreCase("3")) {
                resposta = String.valueOf(acessoHistoricoService.historicoMesAnteriorCompleto()) + "\n" +
                        "1.1 - Bloquear Usuario | 2.2 - Nota | 3.3 - Favoritar ";

            } else if (escolhaMenuHistorico.equalsIgnoreCase("4")) {
                resposta = String.valueOf(acessoHistoricoService.historicoHojeCompleto()) + "\n" +
                        "1.1 - Bloquear Usuario | 2.2 - Nota | 3.3 - Favoritar ";

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