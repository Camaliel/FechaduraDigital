package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.Interface.NumeroFilhosImpl;
import CadastrarSenha.Service.Interface.PatriarcaImpl;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

public class FamiliarService implements PatriarcaImpl, NumeroFilhosImpl {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();

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
        int quantidadeRecebida = 0;

        System.out.println("Digite a quantidade de filhos para o cadastro");
        int numeroFilhos = leia.nextInt();
        quantidadeRecebida = numeroFilhos;

        for (int i = 1; i <= quantidadeRecebida; i++) {
            System.out.println("Digite o proximo filho");
            numeroFilhos = leia.nextInt();
        }

        return quantidadeRecebida;
    }

    // TESTANDO METODOS =>
    public static void main(String[] args) {
        FamiliarService teste = new FamiliarService();
        System.out.println(teste.quantidadeDeFilhos());

    }

}

