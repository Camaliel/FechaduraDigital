package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveToken;

import java.util.Scanner;

public class ConfereChaveToken {
    public String getValorGuardado() {
        return valorGuardado;
    }

    public void setValorGuardado(String valorGuardado) {
        this.valorGuardado = valorGuardado;
    }

    String valorGuardado = "";

    public String validaChaveToken() {
        ChaveToken chaveToken = new ChaveToken();
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite seu token");
        System.out.println("token enviado " + chaveToken.getPegaRoleta());
        valorGuardado = chaveToken.getPegaToken();
        String valorUsuario = leia.nextLine();
        setValorGuardado(valorUsuario);
        if(valorUsuario.equals(chaveToken.getPegaRoleta())){
            System.out.println("Valor confere");
            System.out.println("valor guardado ==> " + valorGuardado);
        }else{
            System.out.println("Valor não confere");
            System.out.println("valor guardado ==> " + valorGuardado);
        }
        leia.close();
        return valorGuardado;
    }

    public static void main(String[] args) {
        ConfereChaveToken confereChaveToken = new ConfereChaveToken();
        confereChaveToken.validaChaveToken();
    }
}
