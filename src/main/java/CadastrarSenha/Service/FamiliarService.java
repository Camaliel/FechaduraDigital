package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Service.Interface.*;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;


public class FamiliarService implements UsuarioPadraoImpl {
    Scanner leia = new Scanner(System.in);
    VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    public static String confirmaPatriarca = "";
    public static String nomeArmazenadoFilho = "";

    /*
     *
     * Logica para adiciona integrantes a fammilia
     * Falta arrumar caso já tenha um patriarca na familia ..
     *
     *  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...


    public String patriarca(String pai) {
        System.out.println(MensagemPatriarcaEnum.PATRIARCA.getDescricao());
        String patriarca = leia.next();

        if (patriarca.contains("sim")) {
            confirmaPatriarca = patriarca;

        } else {
            confirmaPatriarca = patriarca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        return varFamiliar.getPai();
    }

    public String matriarca(String mae) {

        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim") || matriaca.contains("s")) {
//            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;
        } else {
//            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
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

        int quantidadeRecebida = 1;

        quantidadeRecebida = numeroFilhos;

        for (int i = 1; i <= quantidadeRecebida; i++) {
            System.out.println(MensagemEnum.NOME_FILHO.getDescricao() + i);
            String nomeFilhos = leia.next();
            nomeArmazenadoFilho = nomeFilhos;
            System.out.println(MensagemEnum.CPF.getDescricao() + i);
            verificaQuantidadeDigitadoCPF(cpfDigitado);
            System.out.print("PRESS ENTER");
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
        senhaService.cadastroSenha(senhaSegura);
        return senhaSegura;
    }
}