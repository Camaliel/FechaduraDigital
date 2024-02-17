package CadastrarSenha.Repository;


import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.util.Scanner;

import static CadastrarSenha.Service.FamiliarService.nomeArmazenadoFilho;
import static CadastrarSenha.Service.FamiliarService.nomeArmazenadoMae;


public class ArmazenaInformacaoPessoaRepository {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    String numeroCelularDigitado = "";

    InfoUsuario usuario = new InfoUsuario();
    String cpfGuardado = usuario.getCpf();


    FamiliarService familiarService = new FamiliarService();

    public static String confirmaPatriarca = "";

    static String cpfArmazenado = "";

    String senhaCadastrada = usuario.getSenha();
    Conexao DAO = new Conexao();
    Menu menu = new Menu();

    public void logicaPersistencia() {

       maePersisti();

    }

    private void paiPersisti() {

    }


    private void maePersisti() {

        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();


        String cpfUsuario = cpfService.verificaQuantidadeDigitadoCPF(usuario.getCpf()); // TODO ENTENDER PORQUE SO ACEITA COM A VARIAVEL
        cpfService.confirmaCPFDigitado();
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());

        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = nomeArmazenadoMae;
        String cFamilia = confirmaPatriarca;
        String parentesco = "filho(s)";
        String cpf = cpfUsuario;
        String tel = numeroCelularDigitado;
        String senhaSegura = senhaService.senhaSegura;

        String sql = "INSERT INTO pessoas (nome,C_Familia, parentesco,cpf,tel,senha_segura) VALUES (?,?,?,?,?,?)";

        DAO.incluir(sql, nome, cFamilia, parentesco, cpf, tel, senhaSegura);
    }

    private void filhoPersisti() {
        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();


        String cpfUsuario = cpfService.verificaQuantidadeDigitadoCPF(usuario.getCpf()); // TODO ENTENDER PORQUE SO ACEITA COM A VARIAVEL
        cpfService.confirmaCPFDigitado();
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());

        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = nomeArmazenadoFilho;
        String cFamilia = "n";
        String parentesco = "filho(s)";
        String cpf = cpfUsuario;
        String tel = numeroCelularDigitado;
        String senhaSegura = senhaService.senhaSegura;

        String sql = "INSERT INTO pessoas (nome,C_Familia, parentesco,cpf,tel,senha_segura) VALUES (?,?,?,?,?,?)";

        DAO.incluir(sql, nome, cFamilia, parentesco, cpf, tel, senhaSegura);
    }

    public static void main(String[] args) {
        ArmazenaInformacaoPessoaRepository teste = new ArmazenaInformacaoPessoaRepository();
        teste.logicaPersistencia();

    }
}