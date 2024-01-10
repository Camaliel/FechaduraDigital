package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.Interface.NumeroFilhosImpl;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

public class FamiliarService implements PatriarcaImpl, NumeroFilhosImpl {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    String cadastroSenhaFilhos = "";
    String cpfDigitado = "";

    String cpfGuardado = "";

    String nomeFilhos = "";

    /*
     *
     * Logica para adiciona integrantes a fammilia
     * Falta arrumar caso já tenha um patriarca na familia ..
     *
     *  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...

    @Override
    public String patriarca(String pai) {

        System.out.println("Voce e o patriarca?");
        String patriarca = leia.nextLine();
        if (patriarca.contains("sim")) {
            System.out.println(MensagemEnum.E_ENVIANDO.getDescricao());

        } else {
            System.out.println("....");

        }
        return varFamiliar.getPai();
    }

    @Override
    public String matriarca(String mae) {
        FamiliarService familiarService = new FamiliarService();
        System.out.println("Voce e a matriarca?");
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim")) {
            System.out.println(MensagemEnum.E_ENVIANDO.getDescricao());
        } else {
            System.out.println("email nao enviado");
        }

        return varFamiliar.getMae();
    }

    //TODO TRABALHANDO NESSE METODO
    /*
     * Recebe uma determinada quantidade de filhos para fazer um looping no metodo de filhos
     * para o cadastro !
     * */
    public int quantidadeDeFilhos() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite a quantidade de filhos para o cadastro");
        int numeroFilhos = leia.nextInt();

        int quantidadeRecebida = 0;

        quantidadeRecebida = numeroFilhos;

        for (int i = 1; i <= quantidadeRecebida; i++) {
            String nomeFilhos = leia.nextLine();
            System.out.println("Digite o nome filho n° " + i);
            nomeFilhos = leia.nextLine();
            System.out.println("Agora, digite o CPF do filho n° " + i);
            cpfGuardado = cpfService.infoUsuario.setCpf(cpfDigitado);
            cpfService.numeroCpf(cpfDigitado);
            confirmaCPFDigitado();
        }

        return quantidadeRecebida;
    }

    public String confirmaCPFDigitado() {
        String validadorConfirmacao = "";
        System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfService.infoUsuario.getCpf() + " ]\n" + "S/N");
        String confirmaCpf = leia.next();
        while (confirmaCpf.contains("n") || confirmaCpf.contains("N")) {
            System.out.println("Digite novamente o numero do CPF n°");
            cpfService.numeroCpf(cpfDigitado);
            System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfService.infoUsuario.getCpf() + " ]\n" + "S/N");
            confirmaCpf = leia.next();
            if (confirmaCpf.contains("s") || confirmaCpf.contains("S")) {
                cpfService.infoUsuario.setCpf(cpfDigitado);

            }
        }
        System.out.println("CPF " + cpfService.infoUsuario.getCpf() + " cadastrado com sucesso!");
        System.out.println(cpfGuardado);
        return validadorConfirmacao;
    }

    // TESTANDO METODOS =>
    public static void main(String[] args) {
        FamiliarService teste = new FamiliarService();
        teste.quantidadeDeFilhos();

    }

}

