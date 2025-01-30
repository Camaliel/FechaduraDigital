package CadastrarSenha.Service.CpfController;

import CadastrarSenha.Service.CpfService;

import java.io.InputStream;
import java.util.Scanner;

import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.cpfDigitado;

public class CpfController {
    private final CpfService cpfService;
    private final Scanner scanner;



    // Construtor recebe Scanner para facilitar testes
    public CpfController(CpfService cpfService, InputStream inputStream) {
        this.cpfService = cpfService;
        this.scanner = new Scanner(inputStream);
    }

    public String solicitarCpf() {
        System.out.println("Digite seu CPF:");
        String cpfDigitadoPeloUsuario = scanner.nextLine();

        try {
            String cpfValidado = cpfService.verificaQuantidadeDigitadoCPF(cpfDigitadoPeloUsuario);
            cpfDigitado = cpfValidado;
            System.out.println("CPF válido: " + cpfValidado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cpfDigitado;
    }
}
