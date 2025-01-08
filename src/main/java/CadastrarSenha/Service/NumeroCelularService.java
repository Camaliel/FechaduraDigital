package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;

import java.util.Scanner;

import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.numeroCelular;

public class NumeroCelularService  {

    public String adicionaNumero(String digiteSeuNumeroCelular) {
        Scanner leia = new Scanner(System.in);
        String pressEnter = leia.nextLine();
        if (pressEnter.isBlank()) {
            System.out.println(MensagemEnum.INSIRA_NUMERO.getDescricao());
            String numero = leia.nextLine();
            numeroCelular = numero;

            while (numero.length() != 9) {
                if (numero.length() != 9) {
                    System.out.println(MensagemEnum.N_VALIDO.getDescricao());
                    numero = leia.nextLine();
                    numeroCelular = numero;
                }
            }
            if (numero.length() == 9) {
                System.out.println(MensagemEnum.NUMERO_SUCESSO.getDescricao());
                numeroCelular = numero;
                System.out.println(numeroCelular + " " + MensagemEnum.N_ADICIONADO.getDescricao());

            }

            System.out.print("PRESS ENTER");
            String pressEnter2 = leia.nextLine();
        }
        return numeroCelular;

    }
}