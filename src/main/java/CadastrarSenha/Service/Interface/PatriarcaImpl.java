package CadastrarSenha.Service.Interface;

public interface PatriarcaImpl {

    /*
    * Envia mensagem caso senha PATRIARCA da familia
    * caso nao seja nao envia mensagem.
    * */
    String patriarca(String pai);

    /*
    * Condição de envio de mensagem caso senha MATRIARCA
    * caso nao senha não envia mensagem.
    * */

    String matriarca(String mae);
}
