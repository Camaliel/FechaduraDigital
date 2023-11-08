package CadastrarSenha.Service;

import CadastrarSenha.Variaveis.InfoUsuario;

import java.util.Scanner;

public class Cpf {
    InfoUsuario infoUsuario = new InfoUsuario();

    /*
     * METODO PARA INSERIR O CPF PASSANDO COMO PARAMETRO O NUMERO DO CPF COM 11 DIGITOS INCLUINDO O DIGITO
     * SEM ESPAÇO ..
     *
     * */
    public String numeroCpf(String digiteCpf) {
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
        return "agora vai"; // TODO ESPERANDO AULA ENTENDER ...
    }

    public static void main(String[] args) {
        Cpf cpf = new Cpf();
        InfoUsuario infoUsuario1 = new InfoUsuario();
        cpf.numeroCpf(cpf.infoUsuario.getCpf());
        System.out.println(cpf.infoUsuario.getCpf());

    }
}