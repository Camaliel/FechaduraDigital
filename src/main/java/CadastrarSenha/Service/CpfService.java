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

    NumeroCelularService celularService = new NumeroCelularService();
    SenhaService senhaService = new SenhaService();

    CpfController cpf = new CpfController(this,System.in);

    /*
     * Logica para verificar a quantidade de numeros digitados do CPF
     * */

    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {

        String cpfConfirmado = confirmaCPFDigitado(cpfDigitado);
        adicionaNumero(numeroCelular);
        cadastroSenha(senhaSegura);

        return cpfConfirmado;
    }

    public String confirmaCPFDigitado(String digiteSeuCpf) {
        Scanner leia = new Scanner(System.in);
        String confirmaCpf = leia.nextLine();
        cpfDigitado = cpf.solicitarCpf();

        String validadorConfirmacao = "";
        System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfDigitado + " ]\n" + "S/N");
        confirmaCpf = leia.nextLine();

        while (confirmaCpf.contains("n") || confirmaCpf.contains("N")) {
            System.out.println("Digite novamente o numero do CPF n°");


            System.out.println("CONFIMA O CPF CADASTRADO?" + "[ " + cpfDigitado+ " ]\n" + "S/N");
            confirmaCpf = leia.next();

            if (confirmaCpf.contains("s") || confirmaCpf.contains("S")) {
                cpf.solicitarCpf();
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