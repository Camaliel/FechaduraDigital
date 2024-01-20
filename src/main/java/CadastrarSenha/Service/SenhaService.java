package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemSenhaEnum;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class SenhaService implements SenhaUsuarioImpl {
    InfoUsuario usuario = new InfoUsuario();

    public String cadastroSenha(String senha) {
        System.out.println(MensagemSenhaEnum.CADASTRE_SENHA.getDescricao());
        Scanner leia = new Scanner(System.in);
        String usuarioSenhaCadastrada = leia.nextLine();


        while (usuarioSenhaCadastrada.length() < 6) {
            if (usuarioSenhaCadastrada.length() < 6) {

                System.out.println(MensagemSenhaEnum.ERRO_SENHA.getDescricao());

                usuarioSenhaCadastrada = leia.nextLine();
            }

        }
        System.out.println("Senha enviada ao banco");

        return usuarioSenhaCadastrada;
    }

    public static void main(String[] args) {
        SenhaService senhaService = new SenhaService();
        InfoUsuario usuario = new InfoUsuario();
        senhaService.cadastroSenha(usuario.getSenha());
    }

}