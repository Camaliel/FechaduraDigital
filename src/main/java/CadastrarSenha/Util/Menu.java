package CadastrarSenha.Util;

import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

import static CadastrarSenha.Service.FamiliarService.nomeArmazenadoFilho;
import static CadastrarSenha.Service.FamiliarService.nomeArmazenadoMae;

public class Menu implements PatriarcaImpl {
    FamiliarService familiarService = new FamiliarService();
    VarFamiliar varFamiliar = new VarFamiliar();

    Scanner leia = new Scanner(System.in);
   public static String nomeArmazenadoPai = "";


   public static String nomeArmazenadoOutros = "";
   public static String valor = "";

    public String menuParente(String nome) {
        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();
        Menu.valor = valor;
        String valorMenu = varFamiliar.setValorMenu(valor);
        switch (valor) {
            case "1":

                System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String valorPai = varFamiliar.setPai(nomePai);
                nomeArmazenadoPai = varFamiliar.setPai(valorPai);
                break;

            case "2":
                System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                familiarService.matriarca(varFamiliar.getMae());
                String valorMae = varFamiliar.setMae(nomeMae);
                break;

            case "3":
                familiarService.quantidadeDeFilhos();
                String nomeFilho = leia.nextLine();
                String valorFilho = varFamiliar.setFilho(nomeFilho);
                break;

            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                String valorOutros = varFamiliar.setOutros(nomeOutros);
                nomeArmazenadoOutros = varFamiliar.getOutros();
                break;

        }
        return valorMenu;
    }

    @Override
    public String patriarca(String pai) {
        FamiliarService familiarService = new FamiliarService();
        return varFamiliar.getPai();
    }

    @Override
    public String matriarca(String mae) {
        FamiliarService familiarService = new FamiliarService();
        return varFamiliar.getMae();
    }
}