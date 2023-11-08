package CadastrarSenha.Service;


import CadastrarSenha.Enum.Mensagem;
import CadastrarSenha.Variaveis.VarFamiliar;

import java.util.Scanner;

public class Familiar {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();

/*
* Logica para adiciona integrantes a fammilia
* Falta arrumar caso já tenha um patriarca na familia ..
* */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...

    public Mensagem parente(String nome) {

        System.out.println("DIGITE SUA OPCAO:");
        System.out.println("-----------------");

        System.out.println("1 - Pai");
        System.out.println("2 - Mae");
        System.out.println("3 - Filho");
        System.out.println("4 - Outro");

        String valor = leia.nextLine();


        switch (valor) {
            case "1":
                System.out.println("DIGITE SEU NOME");
                String nomePai = leia.nextLine();
                String valorPai = varFamiliar.setPai(nomePai);
                patriarca();
                break;

            case "2":
                System.out.println("DIGITE SEU NOME");
                String nomeMae = leia.nextLine();
                String valorMae = varFamiliar.setMae(nomeMae);
                matriarca();

                break;
            case "3":
                System.out.println("DIGITE SEU NOME");
                String nomeFilho = leia.nextLine();
                String valorFilho = varFamiliar.setFilho(nomeFilho);

                break;
            case "4":
                System.out.println("DIGITE SEU NOME");
                String nomeOutros = leia.nextLine();
                String valorOutros = varFamiliar.setOutros(nomeOutros);
                break;

        }
        return Mensagem.E_ENVIADO;
    }

    public void patriarca() {
        Familiar familiar = new Familiar();
        System.out.println("Voce e o patriarca?");
        String patriarca = leia.nextLine();
        if (patriarca.contains("sim")) {
            System.out.println(Mensagem.E_ENVIANDO.getDescricao());

        } else {
            System.out.println("....");
        }
    }

    public void matriarca() {
        Familiar familiar = new Familiar();
        System.out.println("Voce e a matriarca?");
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim")) {
            System.out.println(Mensagem.E_ENVIANDO.getDescricao());
        }

    }

    public static void main(String[] args) {
        Familiar teste = new Familiar();
        System.out.println(teste.parente(teste.varFamiliar.getMae()));


//        System.out.println("[ " + teste.varFamiliar.getMae() + " ]" + " MAE");
//        System.out.println("[ " +teste.varFamiliar.getPai() + " ]" + " PAI");
//        System.out.println("[ " +teste.varFamiliar.getFilho() + " ]" + " FILHOS");
//        System.out.println("[ " +teste.varFamiliar.getOutros() + " ]" + " OUTROS");

    }
}

