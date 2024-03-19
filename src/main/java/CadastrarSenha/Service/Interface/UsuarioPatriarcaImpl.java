package CadastrarSenha.Service.Interface;

public interface UsuarioPatriarcaImpl {

    /*
     * Menu de opções para usuario padrão com a verificação se é Patriarca/Matriarca.
    * */
    String verificaQuantidadeDigitadoCPF(String digiteCpf);

    String patriarca(String pai);

    String matriarca(String mae);

    String adicionaNumero(String numeroCelular);

    String cadastroSenha(String senha);
}