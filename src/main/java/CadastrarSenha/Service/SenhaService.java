package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemSenhaEnum;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class SenhaService{

   public static String senhaSegura = "";

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

        return senhaSegura;
    }

}