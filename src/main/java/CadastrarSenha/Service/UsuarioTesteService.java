package CadastrarSenha.Service;

import CadastrarSenha.Service.CpfController.CpfController;

import java.io.InputStream;

public class UsuarioTesteService {


    public String CpfAleatorio() {

        CpfController cpf = new CpfController(System.in);
        return cpf.solicitarCpf();

    }

    public static void main(String[] args) {
        UsuarioTesteService usuarioTesteService = new UsuarioTesteService();
        System.out.println(usuarioTesteService.CpfAleatorio());
    }
}
