package CadastrarSenha.Repository;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.CpfService;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.NumeroCelularService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.InfoUsuario;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.FamiliarService.*;
import static CadastrarSenha.Util.Menu.*;


public class ArmazenaInformacaoPessoaRepository {
    Scanner leia = new Scanner(System.in);
    public VarFamiliar varFamiliar = new VarFamiliar();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    String numeroCelularDigitado = "";

    InfoUsuario usuario = new InfoUsuario();
    String cpfGuardado = usuario.getCpf();

    FamiliarService familiarService = new FamiliarService();

    static String cpfArmazenado = "";

    String senhaCadastrada = usuario.getSenha();
    Conexao DAO = new Conexao();
    Menu menu = new Menu();

    public void logicaPersistencia() {
        menu.menuParente(valor);
        if (valor.equals("1")) {
            persistiPai();
        } else if (valor.equals("2")) {
            persistiMae();

        } else if (valor.equals("3")) {
            persistiFilho();

        }else if(valor.equals("4")){
            persistioutro();
        }
    }

    private void persistiPai() {
        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();

        String cpfUsuario = familiarService.patriarca(nomeArmazenadoPai);
        String teste = varFamiliar.getPai();
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());
        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = nomeArmazenadoPai;
        String cFamilia = confirmaPatriarca;
        String parentesco = "Pai";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = senhaService.senhaSegura;

        String sql = "INSERT INTO pessoas (nome,C_Familia, parentesco,cpf,tel,senha_segura) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, cFamilia, parentesco, cpf, tel, senhaSegura);

    }

    private void persistiMae() {
        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();

        String nomeMae = nomeArmazenadoMae;
        String teste = varFamiliar.getMae();
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());
        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = nomeMae;
        String cFamilia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = senhaService.senhaSegura;

        String sql = "INSERT INTO pessoas (nome,C_Familia, parentesco,cpf,tel,senha_segura) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, cFamilia, parentesco, cpf, tel, senhaSegura);
    }

    private void persistiFilho() {
        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();

        String filho = nomeArmazenadoFilho;
        service.verificaQuantidadeDigitadoCPF(cpfDigitado);
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());
        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = filho;
        String cFamilia = "não";
        String parentesco = "filho(s)";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = senhaService.senhaSegura;

        String sql = "INSERT INTO pessoas (nome,C_Familia, parentesco,cpf,tel,senha_segura) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, cFamilia, parentesco, cpf, tel, senhaSegura);
    }
    private void persistioutro() {
        SenhaService senhaService = new SenhaService();
        CpfService service = new CpfService();
        System.out.println(MensagemEnum.CPF.getDescricao());
        service.verificaQuantidadeDigitadoCPF(cpfDigitado);
        numeroCelularDigitado = celularService.adicionaNumero(usuario.getNumeroCelular());
        senhaService.cadastroSenha(senhaService.senhaSegura);

        String nome = nomeArmazenadoOutros;
        String cFamilia = "nao";
        String parentesco = "outros";
        String cpf = cpfDigitado;
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