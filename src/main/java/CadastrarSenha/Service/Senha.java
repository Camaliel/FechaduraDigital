package CadastrarSenha.Service;

import java.util.Scanner;

public class Senha {

    public void cadastroSenha() {

        Scanner leia = new Scanner(System.in);
        System.out.println("CADASTRE UMA SENHA");
        String valor = leia.nextLine();
        while (valor.length() < 6) {
            if (valor.length() < 6 || valor.isBlank()) {
                System.out.println("Erro, escolha uma senha com pelo menos 6 digitos");
                valor = leia.nextLine();
            }
        }
            if (valor.length() == 6) {
                System.out.println("Senha cadastrada");
            }
            leia.close();
        }
        public static void main (String[]args){
            Senha senha = new Senha();
            senha.cadastroSenha();
        }
    }