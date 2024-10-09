package CadastrarSenha.Service;


import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.Interface.*;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import org.glassfish.grizzly.utils.StringFilter;

import java.sql.SQLException;
import java.util.Scanner;

import static CadastrarSenha.Service.CpfService.cpfDigitado;
import static CadastrarSenha.Service.NumeroCelularService.numeroCelularDigitado;
import static CadastrarSenha.Service.SenhaService.senhaSegura;


public class FamiliarService implements UsuarioPadraoImpl {
    static Scanner leia = new Scanner(System.in);
    static VarFamiliar varFamiliar = new VarFamiliar();
    static FamiliarService service = new FamiliarService();
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();
    public static String confirmaPatriarca = "";
    public static String nomeArmazenadoFilho = "";
    public static String nomeDoMeioArmazenadoFilho = "";
    public static String sobrenomeArmazenadoFilho = "";


    /*
     *
     * Logica para adiciona integrantes a fammilia
     * Falta arrumar caso já tenha um patriarca na familia ..
     *
     *  */
    //TODO  --> Falta logica, caso já exista um patriarca na familia...


    public String patriarca(String pai) {
        System.out.println(MensagemPatriarcaEnum.PATRIARCA.getDescricao());
        String patriarca = leia.next();

        if (patriarca.contains("sim")) {
            confirmaPatriarca = patriarca;

        } else {
            confirmaPatriarca = patriarca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        return varFamiliar.getNomePai();
    }

    public String matriarca(String mae) {

        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.nextLine();
        if (matriaca.contains("sim") || matriaca.contains("s")) {
//            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;
        } else {
//            System.out.println(MensagemEnum.ADICIONADO_AO_BANCO.getDescricao());
            confirmaPatriarca = matriaca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        System.out.print("PRESS ENTER");
        return varFamiliar.getMae();
    }

    /*
     * Recebe uma determinada quantidade de filhos para fazer um looping no metodo de filhos
     * para o cadastro !
     * */
    public int quantidadeDeFilhos() throws SQLException, ClassNotFoundException {
        ArmazenaInformacaoPessoaRepository repository = new ArmazenaInformacaoPessoaRepository();
        Scanner leia = new Scanner(System.in);
        int quantidadeRecebida = 0;

        System.out.println(MensagemEnum.QUANTIDADE_FILHO.getDescricao());
        int numeroFilhos = leia.nextInt();

        quantidadeRecebida = numeroFilhos;

        for (int i = 1; i <= quantidadeRecebida; i++) {
            System.out.println(MensagemEnum.NOME_FILHO.getDescricao() + i);
            String nomeFilhos = leia.next();
            nomeArmazenadoFilho = nomeFilhos;

            System.out.println(MensagemEnum.NOME_DO_MEIO.getDescricao() + i);
            String nomeDoMeio = leia.next();
            nomeDoMeioArmazenadoFilho = nomeDoMeio;

            System.out.println(MensagemEnum.ULTIMO_NOME.getDescricao() + i);
            String ultimoNome = leia.next();
            nomeDoMeioArmazenadoFilho = ultimoNome;

            verificaQuantidadeDigitadoCPF(cpfDigitado);
            repository.persistiCadastroFilho();
            System.out.println("PRESS ENTER");
        }
        return quantidadeRecebida;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FamiliarService service = new FamiliarService();
        service.quantidadeDeFilhos();
    }

    @Override
    public String verificaQuantidadeDigitadoCPF(String digiteCpf) {
        cpfService.verificaQuantidadeDigitadoCPF(cpfDigitado);
        return cpfDigitado;
    }

    @Override
    public String adicionaNumero(String numeroCelular) {
        celularService.adicionaNumero(numeroCelularDigitado);
        return numeroCelularDigitado;
    }

    @Override
    public String cadastroSenha(String senha) {
        senhaService.cadastroSenha(senhaSegura);
        return senhaSegura;
    }
}