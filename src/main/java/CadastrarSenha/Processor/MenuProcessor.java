package CadastrarSenha.Processor;

import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Service.Interface.NumeroCelularImpl;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;


public class MenuProcessor implements SenhaUsuarioImpl, NumeroCelularImpl,CpfImpl {
    Menu menu = new Menu();
    SenhaService senhaService = new SenhaService();
    VarFamiliar varFamiliar = new VarFamiliar();
    InfoUsuario usuario = new InfoUsuario();
    NumeroCelularService serviceCelular = new NumeroCelularService();
    CpfService serviceNumeroCpf = new CpfService();
    String numeroCpfGravado = usuario.getCpf();
    String senhaGravada = usuario.getSenha();
    String numeroCelularValido = usuario.getNumeroCelular();
    FamiliarService familiarService = new FamiliarService();


    public void menuPrincipal() {
            InfoUsuario infoUsuario = new InfoUsuario();
            NumeroCelularService service = new NumeroCelularService();



        if (!menu.menuParente(varFamiliar.getValorMenu()).isBlank()) {
            System.out.println("testando mennusssss");

        }
        if (!serviceNumeroCpf.verificaQuantidadeDigitadoCPF(numeroCpfGravado).isBlank()) {
            System.out.println("antes");
//            adicionaNumero(numeroCelularValido);


        }

        if (!serviceCelular.adicionaNumero(numeroCelularValido).isBlank()) {
            cadastroSenha(senhaGravada);
            System.out.println("aqui deu");

        }
        if (!senhaService.cadastroSenha(senhaGravada).isBlank()){
            System.out.println("TUDO OKK");
        }
    }


    public static void main(String[] args) {
        MenuProcessor menu = new MenuProcessor();
        menu.menuPrincipal();
    }

    @Override
    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        return numeroCpfGravado;
    }


    @Override
    public String cadastroSenha(String senha) {
        return senhaGravada;
    }

    @Override
    public String adicionaNumero(String numeroCelular) {
        return numeroCelularValido;
    }


}
