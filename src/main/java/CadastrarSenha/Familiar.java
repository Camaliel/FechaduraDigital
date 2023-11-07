package CadastrarSenha;


import CadastrarSenha.Variaveis.VarFamiliar;

import java.util.Scanner;

public class Familiar {

    VarFamiliar varFamiliar = new VarFamiliar();
    public String parente() {
        Scanner leia = new Scanner(System.in);
        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();



        switch (valor){
            case "1":
          System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String valorPai = varFamiliar.setPai(nomePai);
                break;
            case "2":
          System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                String valorMae = varFamiliar.setMae(nomeMae);
                break;
            case "3":
          System.out.println("DIGITE SEU NOME");
                String nomeFilho = leia.nextLine();
                String valorFilho = varFamiliar.setFilho(nomeFilho);

                break;
            case "4":
          System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                String valorOutros = varFamiliar.setOutros(nomeOutros);
                break;
        }


        return "nome cadastrado";
    }

    public static void main(String[] args) {
        Familiar teste = new Familiar();
        System.out.println(teste.parente());
        System.out.println("[" + teste.varFamiliar.getMae() +"]" + " MAE");
        System.out.println("[" +teste.varFamiliar.getPai() +"]" + " PAI");
        System.out.println("[" +teste.varFamiliar.getFilho() + "]" + " FILHOS");
        System.out.println("[" +teste.varFamiliar.getOutros() + "]" + " OUTROS");

    }
}

