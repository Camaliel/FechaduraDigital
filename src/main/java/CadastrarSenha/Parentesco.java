package CadastrarSenha;

import java.util.Scanner;

public class Parentesco {

    private int qualSeuParentesco(){
        System.out.println("Qual seu parentesco ? ");
        System.out.println(" 1 - Pai");
        System.out.println(" 2 - Mãe");
        System.out.println(" 3 - Filho");
        System.out.println(" 4 - Outros");

        Scanner leia = new Scanner(System.in);
        int valorParente = leia.nextInt();

        if (valorParente == 1){

        }


        return valorParente;
    }

    public static void main(String[] args) {
        Parentesco teste = new Parentesco();

        System.out.println(teste.qualSeuParentesco());
    }
}
