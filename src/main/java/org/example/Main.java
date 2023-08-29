package org.example;

import CadastrarSenha.Senha;

public class Main {
    public static void main(String[] args) {
        Senha senha = new Senha();
        System.out.println("CADASTRE UMA SENHA");

        System.out.println(senha.cadastroSenha());
        System.out.println("SENHA CADASTRADA");
    }

}