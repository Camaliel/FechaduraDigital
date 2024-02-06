package CadastrarSenha.Processor;

import CadastrarSenha.BootTelegramApi.TelaBot;
import CadastrarSenha.Repository.ConfereChaveToken;
import CadastrarSenha.Repository.IncluiToken;
import CadastrarSenha.Repository.incluirPessoaRepository;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.Interface.CpfImpl;
import CadastrarSenha.Service.Interface.SenhaUsuarioImpl;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.ValoresDigitados;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.EnviaToken;
import CadastrarSenha.Repository.IncluiPessoa;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;


public class MenuProcessor implements SenhaUsuarioImpl, CpfImpl {
    Menu menu = new Menu();
    SenhaService senhaService = new SenhaService();
    VarFamiliar varFamiliar = new VarFamiliar();
    InfoUsuario usuario = new InfoUsuario();
    NumeroCelularService serviceCelular = new NumeroCelularService();
    CpfService serviceNumeroCpf = new CpfService();
    String numeroCpfGravado = usuario.getCpf();
    String senhaGravada = usuario.getSenha();

    FamiliarService familiarService = new FamiliarService();

    ConfereChaveToken confereChaveToken = new ConfereChaveToken();

    incluirPessoaRepository pessoaRepository = new incluirPessoaRepository();
    EnviaToken enviaToken = new EnviaToken();

    ValoresDigitados valoresDigitados = new ValoresDigitados();

    /*
     * Processa toda a informação recebida e envia para o BANCO.
     * */

    //TODO LEMBRETE: DEIXAR PADRAO E MAIS LIMPO COMO O MENNU 3

    public void menuPrincipal() throws TelegramApiException, SQLException {
        InfoUsuario infoUsuario = new InfoUsuario();
        NumeroCelularService service = new NumeroCelularService();
        TelaBot ligar = new TelaBot();
        IncluiToken incluiToken = new IncluiToken();

        menu.menuParente(varFamiliar.getValorMenu());
        ligar.ligarApi();
        incluiToken.incluiToken();

        System.out.println("enviando informação do celular ao banco");
        System.out.println("");

        System.out.println("THE FIM");

    }

    public static void main(String[] args) throws TelegramApiException, SQLException {
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
}