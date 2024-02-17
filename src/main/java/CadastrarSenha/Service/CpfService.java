package CadastrarSenha.Service;

import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;


public class CpfService implements CpfImpl {
  String cpfDigitado = "";
    InfoUsuario infoUsuario = new InfoUsuario();
    Scanner leia = new Scanner(System.in);

    /*
     * Logica para verificar a quantidade de numeros digitados do CPF
     * */
    @Override
    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        Scanner lerCpf = new Scanner(System.in);
        String cpf = lerCpf.nextLine();
            cpfDigitado = cpf;
            infoUsuario.setCpf(cpfDigitado);

        while (cpf.length() != 11) {
            if (cpf.length() != 11) {
                System.out.println(CodigoErroExitCode.COD_3.getDescricao());
                cpf = lerCpf.nextLine();
                cpfDigitado = cpf;
                infoUsuario.setCpf(cpfDigitado);
            }
        }
        if (cpf.length() == 11) {
            infoUsuario.setCpf(cpfDigitado);
        }
        return cpfDigitado;
    }

    public String confirmaCPFDigitado() {
        String validadorConfirmacao = "";
        System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + infoUsuario.getCpf() + " ]\n" + "S/N");
        String confirmaCpf = leia.next();
        validadorConfirmacao = confirmaCpf;
        while (confirmaCpf.contains("n") || confirmaCpf.contains("N")) {
            System.out.println("Digite novamente o numero do CPF n°");
            verificaQuantidadeDigitadoCPF(cpfDigitado);
            System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + infoUsuario.getCpf() + " ]\n" + "S/N");
            confirmaCpf = leia.next();
            if (confirmaCpf.contains("s") || confirmaCpf.contains("S")) {
                infoUsuario.setCpf(cpfDigitado);
            }
        }
        System.out.println("CPF " + infoUsuario.getCpf() + " cadastrado com sucesso!");
        System.out.print("PRESS ENTER");
        return validadorConfirmacao;
    }

    public static void main(String[] args) {
        CpfService service = new CpfService();
        InfoUsuario infoUsuario = new InfoUsuario();
        service.verificaQuantidadeDigitadoCPF(infoUsuario.getCpf());
        service.confirmaCPFDigitado();
        System.out.println("CPF ARMAZENADO ==> " + service.infoUsuario.getCpf());
    }

}