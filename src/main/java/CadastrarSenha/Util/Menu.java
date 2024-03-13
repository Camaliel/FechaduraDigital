package CadastrarSenha.Util;

import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

import static CadastrarSenha.Service.FamiliarService.*;

public class Menu {
    FamiliarService familiarService = new FamiliarService();
    VarFamiliar varFamiliar = new VarFamiliar();

    Scanner leia = new Scanner(System.in);
    public static String nomeArmazenadoPai = "";
    public static String nomeArmazenadoMae = "";

    public static String nomeArmazenadoOutros = "";

    public static String valor = "";

    public String menuParente(String nome) {
        ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
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
                String valorMae = varFamiliar.setMae(nomeMae);
                nomeArmazenadoMae = varFamiliar.setMae(valorMae);
                familiarService.matriarca(confirmaPatriarca);
                break;

            case "3":
                familiarService.quantidadeDeFilhos();
                break;

            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                nomeArmazenadoOutros = varFamiliar.setPai(nomeOutros);
                break;

        }
        return valorMenu;
    }
}