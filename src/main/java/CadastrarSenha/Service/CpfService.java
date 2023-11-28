package CadastrarSenha.Service;

import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;


public class CpfService implements CpfImpl {
    InfoUsuario infoUsuario = new InfoUsuario();

    @Override
    public String numeroCpf(String digiteCpf) {
        String numeroCpfDigitado = infoUsuario.getCpf();
        Scanner lerCpf = new Scanner(System.in);

        System.out.println("DIGITE SEU CPF");
        String cpf = lerCpf.nextLine();

        while (cpf.length() != 11) {
            if (cpf.length() != 11) {
                System.out.println("Digito faltando");
                cpf = lerCpf.nextLine();

            }
        }
        if (cpf.length() == 11) {
            System.out.println("CPF Inserido com Sucesso");
            infoUsuario.setCpf(cpf);
        }
        return numeroCpfDigitado ;
    }
    public static void main(String[] args) {

        // TESTANDO COMPORTAMENTO APENAS ....

        CpfService cpfService = new CpfService();
        InfoUsuario infoUsuario = new InfoUsuario();
        cpfService.numeroCpf(infoUsuario.getCpf());
        String numeroCpfValido = cpfService.infoUsuario.getCpf();
        System.out.println(numeroCpfValido);

    }


}