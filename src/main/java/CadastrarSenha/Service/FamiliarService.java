package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.VarFamiliar;

import java.util.Scanner;

public class FamiliarService {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();

/*
*
* Logica para adiciona integrantes a fammilia
* Falta arrumar caso já tenha um patriarca na familia ..
*
*  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...


    public void patriarca() {
        FamiliarService familiarService = new FamiliarService();
        System.out.println("Voce e o patriarca?");
        String patriarca = leia.nextLine();
        if (patriarca.contains("sim")) {
            System.out.println("");
            System.out.println(MensagemEnum.E_ENVIANDO.getDescricao());

        } else {
            System.out.println("....");
        }
    }

    public void matriarca() {
        FamiliarService familiarService = new FamiliarService();
        System.out.println("Voce e a matriarca?");
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim")) {
            System.out.println(MensagemEnum.E_ENVIANDO.getDescricao());
        }

    }

    public static void main(String[] args) {
        FamiliarService teste = new FamiliarService();
        Menu menu = new Menu();
        System.out.println(menu.menuParente(teste.varFamiliar.getMae()));


//        System.out.println("[ " + teste.varFamiliar.getMae() + " ]" + " MAE");
//        System.out.println("[ " +teste.varFamiliar.getPai() + " ]" + " PAI");
//        System.out.println("[ " +teste.varFamiliar.getFilho() + " ]" + " FILHOS");
//        System.out.println("[ " +teste.varFamiliar.getOutros() + " ]" + " OUTROS");

    }
}

