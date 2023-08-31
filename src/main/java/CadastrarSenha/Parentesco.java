package CadastrarSenha;


import CadastrarSenha.Variaveis.Variaveis;

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
                break;
            case "2":
          System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                String valorMae = variaveis.setMae(nomeMae);
                break;
            case "3":
          System.out.println("DIGITE SEU NOME");
                String nomeFilho = leia.nextLine();

                break;
            case "4":
          System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                break;
        }


        return "nome cadastrado";
    }

    public static void main(String[] args) {
        Parentesco teste = new Parentesco();
        Variaveis variaveis = new Variaveis();
        System.out.println(teste.parente());
        System.out.println(variaveis.getMae());


    }
}

