package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemSenhaEnum;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class SenhaService implements SenhaUsuarioImpl {
    InfoUsuario usuario = new InfoUsuario();

    public String cadastroSenha(String senha) {
        String usuarioSenhaCadastrada = "";


        System.out.println(MensagemSenhaEnum.CADASTRE_SENHA.getDescricao());

        Scanner leia = new Scanner(System.in);
        String valor = leia.nextLine();
        while (valor.length() < 6) {
            if (valor.length() < 6 || valor.isBlank()) {
                System.out.println(MensagemSenhaEnum.ERRO_SENHA.getDescricao());
                valor = leia.nextLine();
                usuarioSenhaCadastrada = usuario.setSenha(valor);
            }
        }
        if (valor.length() == 6) {
            System.out.println(MensagemSenhaEnum.SENHA_CADASTRADA.getDescricao());
        }
        leia.close();
        return usuarioSenhaCadastrada;
    }

}