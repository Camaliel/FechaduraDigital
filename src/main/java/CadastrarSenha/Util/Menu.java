package CadastrarSenha.Util;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.FamiliarService;

import java.util.Scanner;

public class Menu {
   FamiliarService familiarService = new FamiliarService();
   Scanner leia = new Scanner(System.in);
    public String menuParente(String nome) {

        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();


        switch (valor) {
            case "1":
                System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String valorPai = familiarService.varFamiliar.setPai(nomePai);
                familiarService.patriarca(valorPai);
                break;

            case "2":
                System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                String valorMae = familiarService.varFamiliar.setMae(nomeMae);
                familiarService.matriarca(valorMae);

                break;
            case "3":
                System.out.println("DIGITE SEU NOME");
                String nomeFilho = leia.nextLine();
                String valorFilho = familiarService.varFamiliar.setFilho(nomeFilho);

                break;
            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                String valorOutros = familiarService.varFamiliar.setOutros(nomeOutros);
                break;

        }
        return "-----------------";
    }

}
