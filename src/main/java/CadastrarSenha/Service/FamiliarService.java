package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Service.Interface.NumeroFilhosImpl;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

public class FamiliarService implements PatriarcaImpl, NumeroFilhosImpl {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    String cpfDigitado = "";

    String cpfGuardado = "";

    public static String confirmaPatriarca = "";

    /*
     *
     * Logica para adiciona integrantes a fammilia
     * Falta arrumar caso já tenha um patriarca na familia ..
     *
     *  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...

    @Override
    public String patriarca(String pai) {

        System.out.println(MensagemPatriarcaEnum.PATRIARCA.getDescricao());
        String patriarca = leia.nextLine();
        if (patriarca.contains("sim")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = patriarca;
        } else {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = patriarca;

        }
        return varFamiliar.getPai();
    }

    @Override
    public String matriarca(String mae) {
        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim")) {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
        } else {
            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
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

        for (int i = 1; i <= quantidadeRecebida; i++) {
            String nomeFilhos = leia.nextLine();
            System.out.println(MensagemEnum.NOME_FILHO.getDescricao() + i);
            nomeFilhos = leia.nextLine();
            System.out.println(MensagemEnum.CPF_FILHO.getDescricao() + i);
            cpfGuardado = cpfService.infoUsuario.setCpf(cpfDigitado);
            cpfService.verificaQuantidadeDigitadoCPF(cpfDigitado);
            cpfService.confirmaCPFDigitado();
        }

        return quantidadeRecebida;
    }
}