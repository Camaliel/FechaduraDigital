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
import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Menu.*;


public class ArmazenaInformacaoPessoaRepository {
    public VarFamiliar varFamiliar = new VarFamiliar();
    NumeroCelularService celularService = new NumeroCelularService();
    InfoUsuario usuario = new InfoUsuario();
    FamiliarService familiarService = new FamiliarService();
    Conexao DAO = new Conexao();
    Menu menu = new Menu();
    SenhaService senhaService = new SenhaService();

    public void logicaPersistencia() {
        menu.menuParente(valor);
        if (valor.equals("1")) {
            persistiPai();
        } else if (valor.equals("2")) {
            persistiMae();

        } else if (valor.equals("3")) {
            persistiFilho();
        } else {
            persistioutro();
        }
    }

    private void persistiPai() {

        String nome = nomeArmazenadoPai;

        String chefe_familia = confirmaPatriarca;
        String parentesco = "Pai";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;

        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);

    }

    private void persistiMae() {
        String mae = nomeArmazenadoMae;

        String nome = mae;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;

        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senha);
    }

    public void persistiFilho() {

        String filho = nomeArmazenadoFilho;

        String nome = filho;
        String chefe_familia = "não";
        String parentesco = "filho(s)";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;

        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senha);
    }

    private void persistioutro() {

        String nome = nomeArmazenadoOutros;
        String chefe_familia = "nao";
        String parentesco = "outros";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;

        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);

    }

    public static void main(String[] args) {
        ArmazenaInformacaoPessoaRepository teste = new ArmazenaInformacaoPessoaRepository();
        teste.logicaPersistencia();

    }
}