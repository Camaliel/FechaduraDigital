package CadastrarSenha.Repository;


import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.sql.SQLException;
import java.util.Scanner;

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

        System.out.println("0 para encerrar o programa");
            fimDoPrograma(0);

    }

    public void fimDoPrograma(int valorDigitado){

        Scanner leia = new Scanner(System.in);
         valorDigitado = leia.nextInt();
        while (valorDigitado == 0){
            break;
        }
    }
    private void persistiPai() throws SQLException, ClassNotFoundException {

        String nome = nomeArmazenadoPai;
        String nomeDoMeio = nomeDoMeioArmazenadoPai;
        String ultimoNome = sobrenomeArmazenadoPai;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "Pai";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;
        String token = this.token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, nome_do_meio, ultimo_nome, chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        String sqlConulta = "INSERT INTO moradores.tbl_consultas (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, token, chefe_familia);
        DAO.incluir(sqlConulta, nome, nomeDoMeio, ultimoNome,token);

        fimDoPrograma(0);
    }

    private void persistiMae() throws SQLException, ClassNotFoundException {

        String nome = nomeArmazenadoMae;
        String nomeDoMeio = nomeDoMeioArmazenadoMae;
        String sobrenome = sobrenomeArmazenadoMae;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, chefe_familia, parentesco,cpf, tel, senha, nome_do_meio, sobrenome) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senha, nomeDoMeio, sobrenome);
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

        String sql =  "INSERT INTO moradores.cadastro (nome, sobrenome, ultimo_nome,chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArmazenaInformacaoPessoaRepository teste = new ArmazenaInformacaoPessoaRepository();
        teste.logicaPersistencia();
    }
}