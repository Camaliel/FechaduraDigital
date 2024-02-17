package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemSenhaEnum;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class SenhaService implements SenhaUsuarioImpl {

   public String senhaSegura = "";

    InfoUsuario usuario = new InfoUsuario();

    public String cadastroSenha(String digiteSenha) {
        System.out.println(MensagemSenhaEnum.CADASTRE_SENHA.getDescricao());
        Scanner leia = new Scanner(System.in);
        String senha = leia.nextLine();
        usuario.setSenha(senha);
        senhaSegura = senha;

        while (senha.length() < 6) {
            if (senha.length() < 6) {

                System.out.println(MensagemSenhaEnum.ERRO_SENHA.getDescricao());
                senha = leia.nextLine();
                usuario.setSenha(senha);

            }
        }
        System.out.println("Senha armezenada");
        System.out.print("PRESS ENTER");

        return senhaSegura;
    }

    public static void main(String[] args) {
        SenhaService senhaService = new SenhaService();

        senhaService.cadastroSenha(senhaService.usuario.getSenha());
        System.out.println();
        System.out.println("teste de senha => " + senhaService.usuario.getSenha());
        System.out.println("teste de senha => " + senhaService.senhaSegura);
    }

}