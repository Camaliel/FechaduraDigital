package CadastrarSenha.BootTelegramApi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Random;

public class TokenUsuario {

    NumeroSalvo numeroSalvo = new NumeroSalvo();
    String numeroDeConfirmacao = String.format("%06d", new Random().nextInt(999999));

    public String numeroAleatorio(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Gera um número de confirmação aleatório de 6 dígitos
            String numeroConfirmacaoSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            System.out.println("Numero enviado");
            System.out.println(numeroConfirmacaoSalvo);


        }
        return numeroSalvo.getNumeroSalvo();
    }
    public String lembraNumeroSalvo(){
        System.out.println("Guardei numero");
        String lembraNumeroSalvo = numeroSalvo.setNumeroSalvo(numeroDeConfirmacao);
        System.out.println(lembraNumeroSalvo);

        return lembraNumeroSalvo;
    }

}
