package CadastrarSenha.BootTelegramApi;

import CadastrarSenha.jdbc.CriarTabelaPessoa;
import CadastrarSenha.jdbc.Entity.ChaveToken;
import CadastrarSenha.jdbc.EnviaToken;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            numeroConfirmacaoSalvo = enviaToken.enviaToken();


            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

           numeroConfirmacaoSalvo = enviaToken.getTokenSalvo();
            System.out.println("Numero enviado ==> " + numeroConfirmacaoSalvo);
            System.out.println("Numero de confirmação -> " + enviaToken.getTokenSalvo());
            System.out.println("Numero de ROLETA -> " + chaveToken.getTesteRoleta());
            System.out.println("TESTE PEGA ROLETAA -> " + chaveToken.getPegaRoleta());


        }
        return numeroSalvo.getNumeroSalvo();
    }


    public String lembraNumeroSalvo() {
//        System.out.println("Guardei numero");
        String lembraNumeroSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);
//        System.out.println(lembraNumeroSalvo);

        return lembraNumeroSalvo;
    }


    public String confirmaToken() {

        Scanner tokenTeclado = new Scanner(System.in);
//        String lembraNumeroSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);

        String tokenSalvo = "";
        System.out.println("Confirme seu token ...");
        String valorDigitado = tokenTeclado.nextLine();

//        while (valorDigitado != lembraNumeroSalvo()) {
        if (valorDigitado.equals(numeroDeConfirmacao)) {
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
