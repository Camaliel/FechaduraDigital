package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Service.Interface.*;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;


public class FamiliarService implements UsuarioImpl {
    Scanner leia = new Scanner(System.in);
    VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    String numeroCelularDigitado = "";

    CpfService cpf = new CpfService();

    InfoUsuario usuario = new InfoUsuario();
    static String cpfGuardado = "";
    String senhaCadastrada = usuario.getSenha();


    public static String confirmaPatriarca = "";
    public static String nomeArmazenadoFilho = "";
    static String cpfArmazenado = "";

    /*
     *
     * Logica para adiciona integrantes a fammilia
     * Falta arrumar caso já tenha um patriarca na familia ..
     *
     *  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...


    @Override
    public String patriarca(String pai) {
        System.out.println(MensagemEnum.CPF.getDescricao());
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        System.out.println();

        System.out.println(MensagemPatriarcaEnum.PATRIARCA.getDescricao());
        String patriarca = leia.nextLine();

        if (patriarca.contains("sim")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao() + "teste");
            verificaQuantidadeDigitadoCPF(cpfDigitado);
            confirmaPatriarca = patriarca;
            System.out.print("PRESS ENTER");
        } else {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = patriarca;
            System.out.print("PRESS ENTER");

        }
        return varFamiliar.getPai();
    }

    @Override
    public String matriarca(String mae) {
        System.out.println(MensagemEnum.CPF.getDescricao());

        verificaQuantidadeDigitadoCPF(cpfDigitado);


        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim") || matriaca.contains("s")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;
        } else {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;

        }
        System.out.print("PRESS ENTER");
        return varFamiliar.getMae();
    }



    /*
     * Recebe uma determinada quantidade de filhos para fazer um looping no metodo de filhos
     * para o cadastro !
     * */
    public int quantidadeDeFilhos() {
        Scanner leia = new Scanner(System.in);

        System.out.println(MensagemEnum.QUANTIDADE_FILHO.getDescricao());
        int numeroFilhos = leia.nextInt();

        int quantidadeRecebida = 0;

        quantidadeRecebida = numeroFilhos;

        for (int i = 1; i <= quantidadeRecebida; i++) {
            System.out.println("nome " + i);
            String nomeFilhos = leia.next();
            nomeFilhos = leia.nextLine();
            System.out.println(MensagemEnum.CPF.getDescricao() + i);
            verificaQuantidadeDigitadoCPF(cpfDigitado);
            System.out.print("PRESS ENTER");
            adicionaNumero(numeroCelularDigitado);
            cadastroSenha(numeroCelularDigitado);

        }
        return quantidadeRecebida;
    }


    public static void main(String[] args) {
        FamiliarService service = new FamiliarService();
        service.quantidadeDeFilhos();
    }

    @Override
    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        cpfService.verificaQuantidadeDigitadoCPF(cpfDigitado);
        return cpfDigitado;
    }

    @Override
    public String adicionaNumero(String numeroCelular) {
        celularService.adicionaNumero(numeroCelularDigitado);
        return numeroCelularDigitado;
    }

    @Override
    public String cadastroSenha(String senha) {
        senhaService.cadastroSenha(senhaService.senhaSegura);
        return senhaService.senhaSegura;
    }
}