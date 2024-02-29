package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Service.Interface.NumeroFilhosImpl;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import javassist.compiler.MemberCodeGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FamiliarService implements PatriarcaImpl, NumeroFilhosImpl {
    Scanner leia = new Scanner(System.in);
     VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    String cpfDigitado = "";
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
        cpf.verificaQuantidadeDigitadoCPF(cpfDigitado);
        System.out.println();

        System.out.println(MensagemPatriarcaEnum.PATRIARCA.getDescricao());
        String patriarca = leia.nextLine();

        if (patriarca.contains("sim")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao()+"teste");
            cpf.verificaQuantidadeDigitadoCPF(cpfDigitado);
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

        cpf.verificaQuantidadeDigitadoCPF(cpfDigitado);

        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;
            System.out.print("PRESS ENTER");
        } else {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;
            System.out.print("PRESS ENTER");

        }
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
        List<String> lista = new ArrayList<>();

        for (int i = 1; i <= quantidadeRecebida; i++) {
            String nomeFilhos = leia.nextLine();
            nomeArmazenadoFilho = nomeFilhos;
            lista.add(nomeArmazenadoFilho);

            System.out.println(MensagemEnum.NOME_FILHO.getDescricao() + i);
            nomeFilhos = leia.nextLine();
            nomeArmazenadoFilho = nomeFilhos;
            lista.add(nomeArmazenadoFilho);

            System.out.println(MensagemEnum.CPF_FILHO.getDescricao() + i);

        }
        return quantidadeRecebida;
    }
}