package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Enum.MensagemPatriarcaEnum;
import CadastrarSenha.Repository.ArmazenaInformacaoPessoaRepository;
import CadastrarSenha.Service.Interface.UsuarioPadraoImpl;
import java.sql.SQLException;
import java.util.Scanner;

import static CadastrarSenha.Service.SenhaService.senhaSegura;
import static CadastrarSenha.Util.Variaveis.VariaveisCadastro.*;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaMatriarca;
import static CadastrarSenha.Util.Variaveis.VariaveisPatriarcas.confirmaPatriarca;


public class FamiliarService implements UsuarioPadraoImpl {
    static Scanner leia = new Scanner(System.in);
    CpfService cpfService = new CpfService();
    SenhaService senhaService = new SenhaService();
    NumeroCelularService celularService = new NumeroCelularService();

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
        System.out.print("PRESS ENTER");
        if (patriarca.contains("sim")) {
            confirmaPatriarca = patriarca;

        } else {
            confirmaPatriarca = patriarca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        System.out.print("PRESS ENTER");
        return confirmaPatriarca;
    }

    public String matriarca(String mae) {

        System.out.println(MensagemPatriarcaEnum.MATRIARCA.getDescricao());
        String matriaca = leia.next();
        System.out.print("PRESS ENTER");
        if (matriaca.contains("sim") || matriaca.contains("s")) {
            confirmaPatriarca = matriaca;
        } else {
            confirmaPatriarca = matriaca;

        }
        verificaQuantidadeDigitadoCPF(cpfDigitado);
        System.out.print("PRESS ENTER");
        return confirmaMatriarca;
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
            sobrenomeArmazenadoFilho = ultimoNome;

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
    public String adicionaNumero(String digiteSeuNumeroCelular) {
        celularService.adicionaNumero(numeroCelular);
        return numeroCelular;
    }

    @Override
    public String cadastroSenha(String senha) {
        senhaService.cadastroSenha(senhaSegura);
        return senhaSegura;
    }
}