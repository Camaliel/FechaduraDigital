package CadastrarSenha;

import java.util.Scanner;

public class Parentesco {

    public String parente() {
        Scanner leia = new Scanner(System.in);
        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();
        Variaveis variaveis = new Variaveis();

        switch (valor){
            case "1":
          System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String guardaNomePai = variaveis.setPai(nomePai);
            case "2":
          System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
            case "3":
          System.out.println("DIGITE SEU NOME");
                String nomeFilho = leia.nextLine();
            case "4":
          System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
        }


        return "nome cadastrado";
    }

    public static void main(String[] args) {
        Parentesco teste = new Parentesco();

        System.out.println(teste.parente());


    }
}

