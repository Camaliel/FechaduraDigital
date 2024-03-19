package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class NumeroCelularService  {
    InfoUsuario infoUsuario = new InfoUsuario();

    public static String numeroCelularDigitado = "";

    public String adicionaNumero(String numeroCelular) {
        Scanner leia = new Scanner(System.in);
        String pressEnter = leia.nextLine();
        if (pressEnter.isBlank()) {
            System.out.println(MensagemEnum.INSIRA_NUMERO.getDescricao());
            String numero = leia.nextLine();
            numeroCelularDigitado = numero;

            while (numero.length() != 9) {
                if (numero.length() != 9) {
                    System.out.println(MensagemEnum.N_VALIDO.getDescricao());
                    numero = leia.nextLine();
                    numeroCelularDigitado = numero;
                }
            }
            if (numero.length() == 9) {
                System.out.println(MensagemEnum.NUMERO_SUCESSO.getDescricao());
                infoUsuario.setNumeroCelular(numeroCelularDigitado);
                System.out.println(infoUsuario.getNumeroCelular() + " " + MensagemEnum.N_ADICIONADO.getDescricao());

            }

            System.out.print("PRESS ENTER");
            String pressEnter2 = leia.nextLine();
        }
        return numeroCelularDigitado;

    }
}