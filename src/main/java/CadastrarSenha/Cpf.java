package CadastrarSenha;

import java.util.Scanner;

public class Cpf {
    public String NumeroCpf() {
        System.out.println("DIGITE SEU CPF");
        Scanner lerCpf = new Scanner(System.in);
        String Cpf1 = lerCpf.nextLine();
        if (Cpf1.length() < 11) {
            System.out.println("Digito faltando");
        } else {
            System.out.println("CPF Inserido com Sucesso");
        }
        return Cpf1;
    }

    public static void main(String[] args) {
        Cpf cpf = new Cpf();
        cpf.NumeroCpf();
    }
}