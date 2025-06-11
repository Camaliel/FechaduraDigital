package CadastrarSenha.Repository;


import CadastrarSenha.Entities.HistoricoEntity;
import CadastrarSenha.Jdbc.DAO.Conexao;
import CadastrarSenha.Service.GeradorDeChaveTokenService;
import CadastrarSenha.Service.GeradorDeNomesDeUsuariosService;
import CadastrarSenha.Service.SenhaService;
import CadastrarSenha.Util.Variaveis.VariaveisHistorico;

import java.sql.SQLException;
import java.util.Random;

import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.*;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaPatriarca;

public class ArmazenaInformacaoPessoaRepository {

    private final Conexao DAO;
    private final ConfereChaveTokenRepository token;
    private final VariaveisHistorico variaveisHistorico;

    // Construtor com injeção de dependências
    public ArmazenaInformacaoPessoaRepository(Conexao DAO, IncluiTokenRepository incluiTokenRepository,
                                              GeradorDeChaveTokenService geradorDeChaveTokenService, ConfereChaveTokenRepository token,
                                              VariaveisHistorico variaveisHistorico) {

        this.DAO = DAO;
        this.token = token;
        this.variaveisHistorico = variaveisHistorico;
    }

    private void fimDoPrograma(int valorDigitado) {
        while (valorDigitado == 0) {
            break;
        }
    }

    public void persistiCadastroAleatorio() throws SQLException, ClassNotFoundException {
        persistiAleatorio();
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

    private boolean persistiAleatorio() throws SQLException, ClassNotFoundException {
        HistoricoEntity entity = new HistoricoEntity();
        HistoricoRepository repository = new HistoricoRepository();
        GeradorDeNomesDeUsuariosService gerador = new GeradorDeNomesDeUsuariosService();

        String nome = gerador.geradorUsuarios();
        String nomeDoMeio = gerador.geradorSobrenome();
        String ultimoNome = gerador.geradorUltimoNome();
        String chefe_familia = gerador.geradorAleatorioChefeFamilia();
        String parentesco = entity.setParentesco("Bot");
        String cpf = gerador();
        String tel = geradorTelefone();
        String senhaSegura = geradorSenha();
        String numeroToken = token.validaChaveToken();

        String sql = "INSERT INTO MORADORES.CADASTRO (NOME, NOME_DO_MEIO, ULTIMO_NOME, CHEFE_FAMILIA, PARENTESCO, CPF, TEL, SENHA) VALUES (?,?,?,?,?,?,?,?)";
        String sqlToken = "INSERT INTO MORADORES.TOKENS (NOME, PARENTESCO, TOKEN, CHEFE_FAMILIA) VALUES (?,?,?,?)";
        String sqlConsulta = "INSERT INTO MORADORES.TBL_CONSULTAS (NOME,NOME_DO_MEIO,ULTIMO_NOME,TOKEN) VALUES (?,?,?,?)";

        DAO.incluir(sql, nome, nomeDoMeio, ultimoNome, chefe_familia, parentesco, cpf, tel, senhaSegura);
        DAO.incluir(sqlToken, nome, parentesco, numeroToken, chefe_familia);
        DAO.incluir(sqlConsulta, nome, nomeDoMeio, ultimoNome, numeroToken);
        repository.enviaHistorico(numeroToken, nome, nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Cadastrado");

        fimDoPrograma(0);
        return true;
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
        repository.enviaHistorico(numeroToken, nome, nomeDoMeio, ultimoNome, variaveisHistorico.getData(), variaveisHistorico.getHora(), parentesco, "Cadastrado");

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

    public String gerador() {
        System.out.println("INFORMAÇÕES PREENCHIDAS AUTO-MAGICAMENTE PARA TESTES");
        Random rnd = new Random();
        int[] numeroRandomico = new int[11];
        String teste = "";
        for (int i = 0; i <= 10; i++) {
            numeroRandomico[i] = rnd.nextInt(10);
            teste += String.valueOf(numeroRandomico[i]);
        }
            return teste;
    }

    public String geradorTelefone() {
        System.out.println("INFORMAÇÕES PREENCHIDAS AUTO-MAGICAMENTE PARA TESTES");
        Random rnd = new Random();
        int[] numeroRandomico = new int[9];
        String teste = "";
        for (int i = 0; i <= 8; i++) {
            numeroRandomico[i] = rnd.nextInt(8);
            teste += String.valueOf(numeroRandomico[i]);
        }
        return teste;
    }

    public String geradorSenha() {
        System.out.println("INFORMAÇÕES PREENCHIDAS AUTO-MAGICAMENTE PARA TESTES");
        Random rnd = new Random();
        int[] numeroRandomico = new int[7];
        String teste = "";
        for (int i = 0; i <= 5; i++) {
            numeroRandomico[i] = rnd.nextInt(6);
            teste += String.valueOf(numeroRandomico[i]);
        }
        return teste;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Conexao DAO = new Conexao();
        IncluiTokenRepository repository = new IncluiTokenRepository();
        GeradorDeChaveTokenService geradorDeChaveTokenService = new GeradorDeChaveTokenService();
        ConfereChaveTokenRepository token = new ConfereChaveTokenRepository(repository, geradorDeChaveTokenService);
        VariaveisHistorico variaveisHistorico1 = new VariaveisHistorico();
        ArmazenaInformacaoPessoaRepository armazenaInformacaoPessoaRepository = new ArmazenaInformacaoPessoaRepository(DAO,
                repository, geradorDeChaveTokenService,token,variaveisHistorico1);

        System.out.println(armazenaInformacaoPessoaRepository.persistiAleatorio());

    }
}