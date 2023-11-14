package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemSenhaEnum;

import java.util.Scanner;

public class SenhaService {

    public void cadastroSenha() {

        Scanner leia = new Scanner(System.in);
        System.out.println(MensagemSenhaEnum.CADASTRE_SENHA.getDescricao());
        String valor = leia.nextLine();
        while (valor.length() < 6) {
            if (valor.length() < 6 || valor.isBlank()) {
                System.out.println(MensagemSenhaEnum.ERRO_SENHA.getDescricao());
                valor = leia.nextLine();
            }
        }
            if (valor.length() == 6) {
                System.out.println(MensagemSenhaEnum.SENHA_CADASTRADA.getDescricao());
            }
            leia.close();
        }
        public static void main (String[]args){
            SenhaService senhaService = new SenhaService();
            senhaService.cadastroSenha();
        }
    }