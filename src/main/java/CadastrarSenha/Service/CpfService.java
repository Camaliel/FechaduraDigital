package CadastrarSenha.Service;

import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;


public class CpfService implements CpfImpl {
    InfoUsuario infoUsuario = new InfoUsuario();
    String numeroCpfValido = "";

    @Override
    public String numeroCpf(String digiteCpf) {
        Scanner lerCpf = new Scanner(System.in);

        System.out.println("DIGITE SEU CPF");
        String cpf = lerCpf.nextLine();

        while (cpf.length() != 11) {
            if (cpf.length() != 11) {
                System.out.println("Digito faltando");
                cpf = lerCpf.nextLine();
                numeroCpfValido = numeroCpf(infoUsuario.setCpf(cpf));

            }
        }
        if (cpf.length() == 11) {
            System.out.println("CPF Inserido com Sucesso");
            infoUsuario.setCpf(cpf);
        }
        return numeroCpfValido ;
    }
}