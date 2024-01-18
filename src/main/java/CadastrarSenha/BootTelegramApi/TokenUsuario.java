package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.jdbc.EnviaToken;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class TokenUsuario {

    NumeroSalvo numeroSalvo = new NumeroSalvo();
    EnviaToken enviaToken = new EnviaToken();
    ChaveToken chaveToken = new ChaveToken();

    String numeroDeConfirmacao = String.format("%06d", new Random().nextInt(999999));

    public String getNumeroConfirmacaoSalvo() {
        return numeroConfirmacaoSalvo;
    }

    String numeroConfirmacaoSalvo = "";


    public String numeroAleatorio(Update update) throws SQLException {
        ChaveToken token = new ChaveToken();
        token.setToken(numeroDeConfirmacao);
        EnviaToken enviaToken = new EnviaToken();

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Gera um número de confirmação aleatório de 6 dígitos
            numeroConfirmacaoSalvo = chaveToken.getPegaRoleta();


            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

           numeroConfirmacaoSalvo = enviaToken.getTokenSalvo();
            System.out.println("Numero enviado ==> " + numeroConfirmacaoSalvo);
            System.out.println("Numero de ROLETA -> " + chaveToken.getPegaRoleta());

        }
        return numeroSalvo.getNumeroSalvo();
    }



    public String confirmaToken() {

        Scanner tokenTeclado = new Scanner(System.in);
//        String lembraNumeroSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);

        String tokenSalvo = "";
        System.out.println("Confirme seu token ...");
        String valorDigitado = tokenTeclado.nextLine();

//        while (valorDigitado != lembraNumeroSalvo()) {
        if (valorDigitado.equals(chaveToken.getPegaToken())) {
            System.out.println("Token confirmado");
//                tokenSalvo = n;
        } else {
            System.out.println("Token invalido");
        }


        return tokenSalvo;
    }

    public static void main(String[] args) {
        TokenUsuario tokenUsuario = new TokenUsuario();
//        tokenUsuario.numeroAleatorio(new Update());
    }

}
