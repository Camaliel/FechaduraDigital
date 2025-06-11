package CadastrarSenha.View;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;

import java.sql.SQLException;
import java.util.Scanner;

import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.*;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaMatriarca;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaPatriarca;

public class Menu {
    private final Scanner leia;
    private final FamiliarService familiarService;
    private final ArmazenaInformacaoPessoaRepository repository;
    private final CpfService cpfService;

    // Construtor com injeção de dependências
    public Menu(FamiliarService familiarService, ArmazenaInformacaoPessoaRepository repository, CpfService cpfService) {
        this.leia = new Scanner(System.in);
        this.familiarService = familiarService;
        this.repository = repository;
        this.cpfService = cpfService;
    }


    public static String valor = "";

    public String menuParente(String nome) throws SQLException, ClassNotFoundException {
        Menu menu = new Menu(familiarService, repository, cpfService);
        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("0 - teste");
        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();
        menu.valor = valor;
        switch (valor) {
            case "0":
                repository.persistiCadastroAleatorio();
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
        return menu.toString();
    }

    public void opcaoPai() throws SQLException, ClassNotFoundException {
        try {
            System.out.println("DIGITE SEU NOME");
            String nomePai = leia.next();
            nomeArmazenadoPai = nomePai;

            System.out.println("DIGITE SEU NOME DO MEIO");
            String nomeDoMeioPai = leia.next();
            nomeDoMeioArmazenadoPai = nomeDoMeioPai;

            System.out.println("DIGITE SEU SOBRENOME");
            String sobrenomePai = leia.next();
            sobrenomeArmazenadoPai = sobrenomePai;

            familiarService.patriarca(confirmaPatriarca);
            repository.persistiCadastroPai();
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
        } catch (Exception e) {
            System.out.println(MensagemEnum.NAO_ADICIONADO_AO_BANCO.getDescricao());

        }
    }

    private void opcaoMae() throws SQLException, ClassNotFoundException {
        try {
            System.out.println("DIGITE SEU NOME");
            String nomeMae = leia.next();
            nomeArmazenadoMae = nomeMae;

            System.out.println("DIGITE SEU NOME DO MEIO");
            String nomeDoMeioMae = leia.next();
            nomeDoMeioArmazenadoMae = nomeDoMeioMae;

            System.out.println("DIGITE SEU ULTIMO NOME");
            String sobrenomeMae = leia.next();
            sobrenomeArmazenadoMae = sobrenomeMae;

            familiarService.matriarca(confirmaMatriarca);
            repository.persistiCadastroMae();
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());

        } catch (Exception e) {
            System.out.println(MensagemEnum.NAO_ADICIONADO_AO_BANCO.getDescricao());
        }
    }

    private void opcaoOutros() throws SQLException, ClassNotFoundException {
        try {
            System.out.println("DIGITE SEU NOME");
            String nomeOutros = leia.next();
            nomeArmazenadoOutros = nomeOutros;
            familiarService.verificaQuantidadeDigitadoCPF(cpfDigitado);

            System.out.println("DIGITE SEU NOME DO MEIO");
            String nomeDoMeioOutros = leia.next();
            nomeDoMeioArmazenadoOutros = nomeDoMeioOutros;

            System.out.println("DIGITE SEU ULTIMO NOME");
            String sobrenomeOutros = leia.next();
            sobrenomeArmazenadoOutros = sobrenomeOutros;
            repository.persistiCadastroOutros();

            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());

        } catch (Exception e) {
            System.out.println(MensagemEnum.NAO_ADICIONADO_AO_BANCO.getDescricao());

        }
    }
}