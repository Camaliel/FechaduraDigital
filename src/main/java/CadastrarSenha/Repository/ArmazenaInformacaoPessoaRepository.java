package CadastrarSenha.Repository;


import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.sql.SQLException;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.FamiliarService.confirmaPatriarca;
import static CadastrarSenha.Service.FamiliarService.nomeArmazenadoFilho;
import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Menu.*;


public class ArmazenaInformacaoPessoaRepository {
    FamiliarService familiarService = new FamiliarService();
    Conexao DAO = new Conexao();
    Menu menu = new Menu();
    ConfereChaveToken token = new ConfereChaveToken();

    public void logicaPersistencia() throws SQLException, ClassNotFoundException {
        menu.menuParente(valor);
        if (valor.equals("1")) {
            persistiPai();
        } else if (valor.equals("2")) {
            persistiMae();
        } else if (valor.equals("3")) {
            familiarService.quantidadeDeFilhos();
        } else {
            persistioutro();
        }
    }

    private void persistiPai() throws SQLException, ClassNotFoundException {

        String nome = nomeArmazenadoPai;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "Pai";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;
        String teste = token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, teste, chefe_familia);
    }

    private void persistiMae() throws SQLException, ClassNotFoundException {
        String mae = nomeArmazenadoMae;

        String nome = mae;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();


        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);

    }

    public void persistiFilho() throws SQLException, ClassNotFoundException {
        String filho = nomeArmazenadoFilho;

        String nome = filho;
        String chefe_familia = "não";
        String parentesco = "filho(s)";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);
    }

    private void persistioutro() throws SQLException, ClassNotFoundException {

        String nome = nomeArmazenadoOutros;
        String chefe_familia = "nao";
        String parentesco = "outros";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;
        String numeroToken = token.validaChaveToken();


        String sql = "INSERT INTO cadastro (nome, chefe_familia, parentesco,cpf, tel, senha) VALUES (?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArmazenaInformacaoPessoaRepository teste = new ArmazenaInformacaoPessoaRepository();
        teste.logicaPersistencia();

    }
}