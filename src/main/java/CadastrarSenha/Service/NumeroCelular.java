package CadastrarSenha.Service;

import java.util.Scanner;

public class NumeroCelular {

    public String adicionaNumero() {

        Scanner leia = new Scanner(System.in);
        System.out.println("Insira um numero");
        String numero = leia.nextLine();



        while (numero.length() != 9) {

            if (numero.length() != 9 ) {
                System.out.println("Insira um numero valido");
                numero = leia.nextLine();
            }
        }
        if (numero.length() == 9) {
            System.out.println("Numero inserido com sucesso ..");

        }
        return "numero " + numero + " Adicionado ao banco de dados";
    }

    public static void main(String[] args) {
        NumeroCelular teste = new NumeroCelular();
        teste.adicionaNumero();
    }
}