package CadastrarSenha.Util;

import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

public class Menu implements PatriarcaImpl {
    FamiliarService familiarService = new FamiliarService();
    VarFamiliar varFamiliar = new VarFamiliar();

    Scanner leia = new Scanner(System.in);

    public String menuParente(String nome) {
        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();
        String valorMenu = varFamiliar.setValorMenu(valor);
        switch (valor) {
            case "1":
                System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String valorPai = familiarService.varFamiliar.setPai(nomePai);
                patriarca(familiarService.patriarca(valorPai));
                break;

            case "2":
                System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                String valorMae = familiarService.varFamiliar.setMae(nomeMae);
                matriarca(familiarService.matriarca(valorMae));
                break;

            case "3":
                familiarService.quantidadeDeFilhos();
                String nomeFilho = leia.nextLine();
                String valorFilho = familiarService.varFamiliar.setFilho(nomeFilho);
                break;

            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                String valorOutros = familiarService.varFamiliar.setOutros(nomeOutros);
                break;

        }
        return valorMenu;
    }

    @Override
    public String patriarca(String pai) {
        FamiliarService familiarService = new FamiliarService();
        return familiarService.varFamiliar.getPai();
    }

    @Override
    public String matriarca(String mae) {
        FamiliarService familiarService = new FamiliarService();
        return familiarService.varFamiliar.getMae();
    }

}
