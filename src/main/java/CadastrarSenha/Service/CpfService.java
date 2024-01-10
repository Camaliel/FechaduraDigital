package CadastrarSenha.Service;

import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;


public class CpfService implements CpfImpl {
    InfoUsuario infoUsuario = new InfoUsuario();


    @Override
    public String numeroCpf(String digiteCpf) {
        String numeroCpfValido = "";
        Scanner lerCpf = new Scanner(System.in);
        
        String cpf = lerCpf.nextLine();

        while (cpf.length() != 11) {
            if (cpf.length() != 11) {
                System.out.println(CodigoErroExitCode.COD_3.getDescricao());
                cpf = lerCpf.nextLine();

            }
        }
        if (cpf.length() == 11) {
            System.out.println("CPF Inserido com Sucesso");
            infoUsuario.setCpf(cpf);
        }
        return numeroCpfValido;
    }

    public static void main(String[] args) {
        CpfService teste = new CpfService();
        InfoUsuario infoUsuario = new InfoUsuario();

        teste.numeroCpf(infoUsuario.getCpf());
    }
}