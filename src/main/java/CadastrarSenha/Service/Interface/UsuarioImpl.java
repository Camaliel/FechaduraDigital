package CadastrarSenha.Service.Interface;

public interface UsuarioImpl {
    String verificaQuantidadeDigitadoCPF(String digiteCpf);

    String patriarca(String pai);

    String matriarca(String mae);

    String adicionaNumero(String numeroCelular);

    String cadastroSenha(String senha);

}
