package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class NumeroCelularService {

    public String adicionaNumero() {
        InfoUsuario infoUsuario = new InfoUsuario();
        Scanner leia = new Scanner(System.in);
        System.out.println("Insira um numero");
        String numero = leia.nextLine();

        while (numero.length() != 9) {

            if (numero.length() != 9) {
                System.out.println("Insira um numero valido");
                numero = leia.nextLine();
            }
        }
        if (numero.length() == 9) {
            System.out.println("Numero inserido com sucesso ..");
            infoUsuario.setNumeroCelular(numero);
            System.out.println(numero + " " + MensagemEnum.N_ADICIONADO.getDescricao());

        }

        return infoUsuario.getNumeroCelular(); //TODO matar duvida sobre memoria deve se ter uma variavel pra ser armazenada

    }
    public static void main(String[] args) {
        String numeroTeste = "";
        NumeroCelularService teste = new NumeroCelularService();
        numeroTeste = teste.adicionaNumero();
        System.out.println(numeroTeste);
    }
}