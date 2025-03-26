package CadastrarSenha.Service.CpfController;

import CadastrarSenha.ExitCode.CodigoErroExitCode;
import CadastrarSenha.Service.CpfService;

import java.io.InputStream;
import java.util.Scanner;

public class CpfController {
    private final Scanner scanner;

    // Construtor recebe Scanner para facilitar testes
    public CpfController(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String solicitarCpf() {
        System.out.println("Digite seu CPF:");
        String cpfDigitadoPeloUsuario = scanner.nextLine();
        System.out.print("PRESS ENTER");

        while (cpfDigitadoPeloUsuario.length() < 11) {
            System.out.println(CodigoErroExitCode.COD_3.getDescricao());
            if (!scanner.hasNextLine()) {  // Se não houver mais entrada, encerra
                break;
            }

            try {
                System.out.println("CPF válido: " + cpfDigitadoPeloUsuario);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cpfDigitadoPeloUsuario;
    }
}