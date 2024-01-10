package CadastrarSenha.Service;

import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;


public class CpfService implements CpfImpl {
    InfoUsuario infoUsuario = new InfoUsuario();

    /*
    * Logica para verificar a quantidade de numeros digitados do CPF
    * */
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
//            System.out.println("CPF Inserido com Sucesso");
            infoUsuario.setCpf(cpf);
        }
        return numeroCpfValido;
    }

}