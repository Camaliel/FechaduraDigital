package CadastrarSenha.Repository;


import CadastrarSenha.Entities.HistoricoEntity;
import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.sql.SQLException;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.FamiliarService.*;
import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Menu.*;


public class ArmazenaInformacaoPessoaRepository {
    FamiliarService familiarService = new FamiliarService();
    Conexao DAO = new Conexao();
    ConfereChaveToken token = new ConfereChaveToken();


    public void fimDoPrograma(int valorDigitado){
        while (valorDigitado == 0){
            break;
        }
    }

    public void persistiCadastroPai() throws SQLException, ClassNotFoundException {
        persistiPai();
    }
    public void persistiCadastroMae() throws SQLException, ClassNotFoundException {
        persistiMae();
    }
    public void persistiCadastroFilho() throws SQLException, ClassNotFoundException {
        persistiFilho();
    }
    public void persistiCadastroOutros() throws SQLException, ClassNotFoundException {
        persistioutro();
    }

    private void persistiPai() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoPai;
        String nomeDoMeio = nomeDoMeioArmazenadoPai;
        String ultimoNome = sobrenomeArmazenadoPai;
        String chefe_familia = confirmaPatriarca;
        String parentesco = entity.setParentesco("Pai");
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;
        String token = this.token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, nome_do_meio, ultimo_nome, chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO moradores.tbl_consultas (nome, nome_do_meio, ultimo_nome, token) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, token, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome,token);
        repository.enviaHistorico(parentesco,"CADASTRADO");


        fimDoPrograma(0);
    }

    private void persistiMae() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoMae;
        String nomeDoMeio = nomeDoMeioArmazenadoMae;
        String ultimoNome = sobrenomeArmazenadoMae;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, nome_do_meio, ultimo_nome, chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO moradores.tbl_consultas (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome,numeroToken);
        repository.enviaHistorico(parentesco,"CADASTRADO");
    }

    private void persistiFilho() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoFilho;
        String nomeDoMeio = nomeDoMeioArmazenadoFilho;
        String ultimoNome = sobrenomeArmazenadoFilho;
        String chefe_familia = "não";
        String parentesco = "filho(s)";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO moradores.cadastro (nome, nome_do_meio, ultimo_nome, chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        String sqlTblConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (ID_NOME, NOME, NOME_DO_MEIO, ULTIMO_NOME, TOKEN)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlTblConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(parentesco,"CADASTRADO");
    }

    private void persistioutro() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoOutros;
        String nomeDoMeio = nomeDoMeioArmazenadoOutros;
        String ultimoNome = sobrenomeArmazenadoOutros;
        String chefe_familia = "nao";
        String parentesco = "outros";
        String cpf = cpfDigitado;
        String tel = numeroCelularDigitado;
        String senhaSegura = SenhaService.senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql =  "INSERT INTO moradores.cadastro (nome, sobrenome, ultimo_nome,chefe_familia, parentesco, cpf, tel, senha) VALUES (?,?,?,?,?,?,?,?)";
        String sqlNome = "INSERT INTO moradores.tokens (nome, parentesco, token, chefe_familia) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO moradores.tbl_consultas (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlNome, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome,numeroToken);
        repository.enviaHistorico(parentesco,"CADASTRADO");
    }
}