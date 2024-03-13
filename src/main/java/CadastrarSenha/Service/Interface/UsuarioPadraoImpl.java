package CadastrarSenha.Service.Interface;

public interface UsuarioPadraoImpl {
    /*
    * Menu de opções para usuario padrão sem a verificação se é Patriarca/Matriarca.
    * */
    String verificaQuantidadeDigitadoCPF(String digiteCpf);

    String adicionaNumero(String numeroCelular);

    String cadastroSenha(String senha);

}
