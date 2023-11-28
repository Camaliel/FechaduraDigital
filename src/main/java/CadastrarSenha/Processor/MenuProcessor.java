package CadastrarSenha.Processor;

import CadastrarSenha.Service.Interface.NumeroCelularImpl;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;


public class MenuProcessor implements NumeroCelularImpl, SenhaUsuarioImpl {
    Menu menu = new Menu();
    SenhaService senhaService = new SenhaService();
    VarFamiliar varFamiliar = new VarFamiliar();
    InfoUsuario usuario = new InfoUsuario();
    NumeroCelularService numeroCelularService = new NumeroCelularService();

    String numeroUsuario = usuario.setNumeroCelular("");

    String senhaUsuarioGravado = usuario.setSenha("999");

    public void menuPrincipal() {
        if (!menu.menuParente(varFamiliar.getValorMenu()).isBlank()) {
            System.out.println("proxima etapa");
            numeroCelularService.adicionaNumero(usuario.getNumeroCelular());

            if (!numeroUsuario.isBlank()) {
                System.out.println("proxima etapa");
                cadastroSenha(senhaUsuarioGravado);
                System.out.println("CADASTRO GRAVADO");
            }
            if (!cadastroSenha(senhaUsuarioGravado).isBlank()) {
                System.out.println("PROXIMA ETAPA");

            } else {
                System.out.println("NAO FOI ");
            }

        }

    }

    @Override
    public String adicionaNumero(String numeroCelular) {
        return numeroUsuario;

    }

    @Override
    public String cadastroSenha(String senha) {
        return senhaUsuarioGravado;
    }

    public static void main(String[] args) {
        MenuProcessor menu = new MenuProcessor();
        menu.menuPrincipal();
    }


}
