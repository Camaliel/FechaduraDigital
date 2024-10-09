package CadastrarSenha.Util;

import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.sql.SQLException;
import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;

public class Menu {
    FamiliarService familiarService = new FamiliarService();
    VarFamiliar varFamiliar = new VarFamiliar();
    CpfService service = new CpfService();

    Scanner leia = new Scanner(System.in);

    public static String nomeArmazenadoPai = "";
    public static String nomeDoMeioArmazenadoPai = "";
    public static String sobrenomeArmazenadoPai = "";

    public static String nomeArmazenadoMae = "";
    public static String nomeDoMeioArmazenadoMae = "";
    public static String sobrenomeArmazenadoMae = "";

    public static String nomeDoMeioArmazenadoOutros = "";
    public static String sobrenomeArmazenadoOutros = "";
    public static String nomeArmazenadoOutros = "";

    public static String valor = "";

    ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();

    public String menuParente(String nome) throws SQLException, ClassNotFoundException {
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
                opcaoPai();
                break;

            case "2":
                opcaoMae();
                break;

            case "3":
                familiarService.quantidadeDeFilhos();
                break;

            case "4":
                opcaoOutros();

        }
        return valorMenu;
    }


    private void opcaoPai() throws SQLException, ClassNotFoundException {
        System.out.println("DIGITE SEU NOME");
        String nomePai = leia.next();
        nomeArmazenadoPai = varFamiliar.setPai(nomePai);

        System.out.println("DIGITE SEU NOME DO MEIO");
        String nomeDoMeioPai = leia.next();
        nomeDoMeioArmazenadoPai = varFamiliar.setNomeDoMeioPai(nomeDoMeioPai);

        System.out.println("DIGITE SEU SOBRENOME");
        String sobrenomePai = leia.next();
        sobrenomeArmazenadoPai = varFamiliar.setSobrenomePai(sobrenomePai);
        familiarService.patriarca(varFamiliar.getNomePai());
        repository.persistiCadastroPai();
    }
    private void opcaoMae() throws SQLException, ClassNotFoundException {
        System.out.println("DIGITE SEU NOME");
        String nomeMae = leia.next();
        nomeArmazenadoMae = varFamiliar.setMae(nomeMae);

        System.out.println("DIGITE SEU NOME DO MEIO");
        String nomeDoMeioMae = leia.next();
        nomeDoMeioArmazenadoMae = varFamiliar.setNomeDoMeioMae(nomeDoMeioMae);

        System.out.println("DIGITE SEU ULTIMO NOME");
        String sobrenomeMae = leia.next();
        sobrenomeArmazenadoMae = varFamiliar.setSobrenomeMae(sobrenomeMae);

        familiarService.matriarca(varFamiliar.getMae());
        repository.persistiCadastroMae();

    }
    private void opcaoOutros() throws SQLException, ClassNotFoundException {
        System.out.println("DIGITE SEU NOME");
        String nomeOutros = leia.next();
        nomeArmazenadoOutros = varFamiliar.setPai(nomeOutros);
        service.verificaQuantidadeDigitadoCPF(cpfDigitado);

        System.out.println("DIGITE SEU NOME DO MEIO");
        String nomeDoMeioOutros = leia.next();
        nomeDoMeioArmazenadoOutros = varFamiliar.setNomeDoMeioOutros(nomeDoMeioOutros);

        System.out.println("DIGITE SEU ULTIMO NOME");
        String sobrenomeOutros = leia.next();
        sobrenomeArmazenadoOutros = varFamiliar.setSobrenomeOutros(sobrenomeOutros);
        repository.persistiCadastroOutros();
    }
}