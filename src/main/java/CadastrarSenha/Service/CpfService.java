package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.Interface.UsuarioPadraoImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;


public class CpfService implements UsuarioPadraoImpl {
    public static String cpfDigitado = "";
    InfoUsuario infoUsuario = new InfoUsuario();
    Scanner leia = new Scanner(System.in);
    Scanner lerCpf = new Scanner(System.in);
    NumeroCelularService celularService = new NumeroCelularService();
    SenhaService senhaService = new SenhaService();

    /*
     * Logica para verificar a quantidade de numeros digitados do CPF
     * */

    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        System.out.println(MensagemEnum.CPF.getDescricao());
        String cpf = lerCpf.nextLine();
        cpfDigitado = cpf;

        while (cpf.length() != 11) {
                System.out.println(CodigoErroExitCode.COD_3.getDescricao());
                cpf = lerCpf.nextLine();
                cpfDigitado = cpf;
                infoUsuario.setCpf(cpfDigitado);
        }
        if (cpf.length() == 11) {
            infoUsuario.setCpf(cpfDigitado);
        }
        confirmaCPFDigitado();
        adicionaNumero(numeroCelularDigitado);
        cadastroSenha(senhaSegura);

        return cpfDigitado;
    }

    public String confirmaCPFDigitado() {

        String validadorConfirmacao = "";
        System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + infoUsuario.getCpf() + " ]\n" + "S/N");

        String confirmaCpf = leia.nextLine();
        validadorConfirmacao = confirmaCpf;

        while (confirmaCpf.contains("n") || confirmaCpf.contains("N")) {
            System.out.println("Digite novamente o numero do CPF n°");

            String cpf = leia.nextLine();
            cpfDigitado = cpf;

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

    @Override
    public String adicionaNumero(String numeroCelular) {
        celularService.adicionaNumero(numeroCelularDigitado);
        return numeroCelularDigitado;
    }

    @Override
    public String cadastroSenha(String senha) {
        InfoUsuario usuario = new InfoUsuario();
        senhaService.cadastroSenha(senhaSegura);
        return senhaSegura;
    }
}