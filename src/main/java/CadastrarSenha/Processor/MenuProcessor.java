package CadastrarSenha.Processor;

import CadastrarSenha.Service.Interface.NumeroCelularImpl;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;


public class MenuProcessor implements NumeroCelularImpl {
    Menu menu = new Menu();
    VarFamiliar varFamiliar = new VarFamiliar();
    InfoUsuario usuario = new InfoUsuario();

    @Override
    public String adicionaNumero(String numeroCelular) {
         String numeroUsuario = usuario.getNumeroCelular();

        return numeroUsuario;

    }

    public void menuPrincipal() {
        if (!menu.menuParente(varFamiliar.getValorMenu()).isBlank()) {

            System.out.println("proxima etapa");
            System.out.println(adicionaNumero(usuario.getNumeroCelular()));


        }

    }


    public static void main(String[] args) {

        MenuProcessor menu = new MenuProcessor();
        menu.menuPrincipal();
    }
}
