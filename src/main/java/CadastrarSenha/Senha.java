package CadastrarSenha;

import java.util.Scanner;

public class Senha {

    public int cadastroSenha() {

        Scanner leia = new Scanner(System.in);
        int valor = leia.nextInt();

        leia.close();

        return valor;
    }
}