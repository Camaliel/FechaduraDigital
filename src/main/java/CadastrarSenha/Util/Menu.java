package CadastrarSenha.Util;

import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.FamiliarService.*;

public class Menu {
    FamiliarService familiarService = new FamiliarService();
    VarFamiliar varFamiliar = new VarFamiliar();
    CpfService service = new CpfService();

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
                String nomePai = leia.next();
                nomeArmazenadoPai = varFamiliar.setPai(nomePai);
                familiarService.patriarca(varFamiliar.getPai());
                break;

            case "2":
                System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.next();
                nomeArmazenadoMae = varFamiliar.setPai(nomeMae);
                familiarService.matriarca(varFamiliar.getMae());
                break;

            case "3":
                familiarService.quantidadeDeFilhos();
                break;

            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.next();
                nomeArmazenadoOutros = varFamiliar.setPai(nomeOutros);
                familiarService.verificaQuantidadeDigitadoCPF(cpfDigitado);
                break;

        }
        return valorMenu;
    }
}