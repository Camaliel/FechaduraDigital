package CadastrarSenha.Repository;


import CadastrarSenha.Entities.HistoricoEntity;
import CadastrarSenha.Service.GeradorDeChaveTokenService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;
import CadastrarSenha.Jdbc.DAO.Conexao;

import java.sql.SQLException;

import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.*;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaPatriarca;

public class ArmazenaInformacaoPessoaRepository {

    private final Conexao DAO;
    private final IncluiTokenRepository incluiTokenRepository;
    private final GeradorDeChaveTokenService geradorDeChaveTokenService;
    private final ConfereChaveTokenRepository token;
    private final VariaveisHistorico variaveisHistorico;

    // Construtor com injeção de dependências
    public ArmazenaInformacaoPessoaRepository(Conexao DAO, IncluiTokenRepository incluiTokenRepository,
                                              GeradorDeChaveTokenService geradorDeChaveTokenService, ConfereChaveTokenRepository token,
                                              VariaveisHistorico variaveisHistorico) {

        this.DAO = DAO;
        this.incluiTokenRepository = incluiTokenRepository;
        this.geradorDeChaveTokenService = geradorDeChaveTokenService;
        this.token = token;
        this.variaveisHistorico = variaveisHistorico;
    }

    private void fimDoPrograma(int valorDigitado) {
        while (valorDigitado == 0) {
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

    //TODO ARRUMADO, FALTA SOMENTE AJUSTAR OS OUTROS PARA QUE FIQUE DE FORMA UNIFORME E FALTA TOKEN NOS OUTROS...FALTA AJUSTAR O HISTORICO.. O ERRO ERA N
    private void persistiPai() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoPai;
        String nomeDoMeio = nomeDoMeioArmazenadoPai;
        String ultimoNome = sobrenomeArmazenadoPai;
        String chefe_familia = confirmaPatriarca;
        String parentesco = entity.setParentesco("Pai");
        String cpf = cpfDigitado;
        String tel = numeroCelular;
        String senhaSegura = SenhaService.senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO MORADORES.CADASTRO (NOME, NOME_DO_MEIO, ULTIMO_NOME, CHEFE_FAMILIA, PARENTESCO, CPF, TEL, SENHA) VALUES (?,?,?,?,?,?,?,?)";
        String sqlToken = "INSERT INTO MORADORES.TOKENS (NOME, PARENTESCO, TOKEN, CHEFE_FAMILIA) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlToken, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(numeroToken, nome, nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Cadastrado");

        fimDoPrograma(0);
    }

    private void persistiMae() throws SQLException, ClassNotFoundException {
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoMae;
        String nomeDoMeio = nomeDoMeioArmazenadoMae;
        String ultimoNome = sobrenomeArmazenadoMae;
        String chefe_familia = confirmaPatriarca;
        String parentesco = "mae";
        String cpf = cpfDigitado;
        String tel = numeroCelular;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO MORADORES.CADASTRO (NOME, NOME_DO_MEIO, ULTIMO_NOME, CHEFE_FAMILIA, PARENTESCO, CPF, TEL, SENHA) VALUES (?,?,?,?,?,?,?,?)";
        String sqlToken = "INSERT INTO MORADORES.TOKENS (NOME, PARENTESCO, TOKEN, CHEFE_FAMILIA) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlToken, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(parentesco, nome, nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Cadastrado");

    }

    private void persistiFilho() throws SQLException, ClassNotFoundException {
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoFilho;
        String nomeDoMeio = nomeDoMeioArmazenadoFilho;
        String ultimoNome = sobrenomeArmazenadoFilho;
        String chefe_familia = "não";
        String parentesco = "filho(s)";
        String cpf = cpfDigitado;
        String tel = numeroCelular;
        String senha = senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO MORADORES.CADASTRO (NOME, NOME_DO_MEIO, ULTIMO_NOME, CHEFE_FAMILIA, PARENTESCO, CPF, TEL, SENHA) VALUES (?,?,?,?,?,?,?,?)";
        String sqlToken = "INSERT INTO MORADORES.TOKENS (NOME, PARENTESCO, TOKEN, CHEFE_FAMILIA) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senha);
        DAO.incluir(sqlToken, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(parentesco, nome, nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Cadastrado");
    }

    private void persistioutro() throws SQLException, ClassNotFoundException {
        HistoricoRepository repository = new HistoricoRepository();

        String nome = nomeArmazenadoOutros;
        String nomeDoMeio = nomeDoMeioArmazenadoOutros;
        String ultimoNome = sobrenomeArmazenadoOutros;
        String chefe_familia = "nao";
        String parentesco = "outros";
        String cpf = cpfDigitado;
        String tel = numeroCelular;
        String senhaSegura = SenhaService.senhaSegura;
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO MORADORES.CADASTRO (NOME, NOME_DO_MEIO, ULTIMO_NOME, CHEFE_FAMILIA, PARENTESCO, CPF, TEL, SENHA) VALUES (?,?,?,?,?,?,?,?)";
        String sqlToken = "INSERT INTO MORADORES.TOKENS (NOME, PARENTESCO, TOKEN, CHEFE_FAMILIA) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlToken, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(parentesco, "CADASTRADO", nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Liberada");
    }
}