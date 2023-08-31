package CadastrarSenha;

import java.util.Scanner;

public class NumeroCelular {

   public String numeroCelular(){
       System.out.println("Cadatre um numero de celular valido: ");
       Scanner input = new Scanner(System.in);
       String nCelular = input.nextLine();


       return "Numero cadastrado";
   }

    public static void main(String[] args) {
        NumeroCelular teste = new NumeroCelular();
        System.out.println(teste.numeroCelular());
    }
}
