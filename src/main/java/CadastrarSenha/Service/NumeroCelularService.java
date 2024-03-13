package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.Interface.NumeroCelularImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class NumeroCelularService implements NumeroCelularImpl {
    InfoUsuario infoUsuario = new InfoUsuario();

    String numeroDigitado = "";

    @Override
    public String adicionaNumero(String numeroCelular) {
        Scanner leia = new Scanner(System.in);
        String pressEnter = leia.nextLine();
        if (pressEnter.isBlank()) {
            System.out.println(MensagemEnum.INSIRA_NUMERO.getDescricao());
            String numero = leia.nextLine();
            infoUsuario.setNumeroCelular(numero);
            numeroDigitado = numero;

            while (numero.length() != 9) {
                if (numero.length() != 9) {
                    System.out.println(MensagemEnum.N_VALIDO.getDescricao());
                    numero = leia.nextLine();
                    infoUsuario.setNumeroCelular(numero);
                    numeroDigitado = numero;
                }
            }
            if (numero.length() == 9) {
                System.out.println(MensagemEnum.NUMERO_SUCESSO.getDescricao());
                infoUsuario.setNumeroCelular(numeroDigitado);
                System.out.println(infoUsuario.getNumeroCelular() + " " + MensagemEnum.N_ADICIONADO.getDescricao());

            }

            System.out.print("PRESS ENTER");
            String pressEnter2 = leia.nextLine();
        }
        return numeroDigitado;

    }
}