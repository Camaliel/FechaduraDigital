package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.CpfController.CpfController;
import CadastrarSenha.Service.Interface.UsuarioPadraoImpl;
import java.util.Scanner;

import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.cpfDigitado;
import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.numeroCelular;


public class CpfService implements UsuarioPadraoImpl {

    Scanner leia = new Scanner(System.in);
    Scanner lerCpf = new Scanner(System.in);
    NumeroCelularService celularService = new NumeroCelularService();
    SenhaService senhaService = new SenhaService();
    CpfService cpfService = new CpfService();
    CpfController cpf = new CpfController(cpfService, System.in);


    /*
     * Logica para verificar a quantidade de numeros digitados do CPF
     * */

    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        System.out.println(MensagemEnum.CPF.getDescricao());


        while (cpf.solicitarCpf().length() != 11) {
                System.out.println(CodigoErroExitCode.COD_3.getDescricao());
                cpf.solicitarCpf();
        }
        if (cpf.solicitarCpf().length() == 11) {
           cpf.solicitarCpf();

        }
        confirmaCPFDigitado();
        adicionaNumero(numeroCelular);
        cadastroSenha(senhaSegura);

        return cpfDigitado;
    }

    public String confirmaCPFDigitado() {

        String validadorConfirmacao = "";
        System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfDigitado+ " ]\n" + "S/N");

        String confirmaCpf = leia.nextLine();
        validadorConfirmacao = confirmaCpf;

        while (confirmaCpf.contains("n") || confirmaCpf.contains("N")) {
            System.out.println("Digite novamente o numero do CPF n°");

            String cpf = leia.nextLine();
            cpfDigitado = cpf;

            System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfDigitado+ " ]\n" + "S/N");
            confirmaCpf = leia.next();

            if (confirmaCpf.contains("s") || confirmaCpf.contains("S")) {
                cpfDigitado = cpf;
            }
        }
        System.out.println("CPF " + cpfDigitado + " cadastrado com sucesso!");
        System.out.print("PRESS ENTER");
        return validadorConfirmacao;
    }

    @Override
    public String adicionaNumero(String digiteSeuNumeroCelular) {
        celularService.adicionaNumero(numeroCelular);
        return numeroCelular;
    }

    @Override
    public String cadastroSenha(String senha) {
        senhaService.cadastroSenha(senhaSegura);
        return senhaSegura;
    }
}