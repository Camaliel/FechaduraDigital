package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Random;
import java.util.Scanner;

public class TokenUsuario {

    NumeroSalvo numeroSalvo = new NumeroSalvo();
    String numeroDeConfirmacao = String.format("%06d", new Random().nextInt(999999));

    String numeroConfirmacaoSalvo = "";

    public String numeroAleatorio(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Gera um número de confirmação aleatório de 6 dígitos
             numeroConfirmacaoSalvo = numeroSalvo.setNumeroSalvo("9999");

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            System.out.println("Numero enviado");
//            System.out.println(numeroConfirmacaoSalvo);


        }
        return numeroSalvo.getNumeroSalvo();
    }
//    public String lembraNumeroSalvo(){
////        System.out.println("Guardei numero");
//        String lembraNumeroSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);
////        System.out.println(lembraNumeroSalvo);
//
//        return lembraNumeroSalvo;
//    }


    public String confirmaToken(){

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
        tokenUsuario.confirmaToken();
    }

}
