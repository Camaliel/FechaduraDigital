package Tela;

import CadastrarSenha.Service.Familiar;
import CadastrarSenha.Service.NumeroCelular;
import CadastrarSenha.Variaveis.VarFamiliar;

public class    Main {
    public static void main(String[] args) {
        Familiar teste = new Familiar();
        NumeroCelular numeroCelular = new NumeroCelular();
        VarFamiliar varFamiliar = new VarFamiliar();
        System.out.println(teste.parente(teste.varFamiliar.getMae()));
        System.out.println(numeroCelular.adicionaNumero());

    }

}