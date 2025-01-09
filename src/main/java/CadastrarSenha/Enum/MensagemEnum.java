package CadastrarSenha.Enum;

public enum MensagemEnum {

    ADICIONADO_AO_BANCO("Enviado ao banco de dados"),
    NAO_ADICIONADO_AO_BANCO("Não enviado ao banco"),
    NOME_FILHO("Digite o [nome] filho n° "),
    NOME_DO_MEIO("Digite o [sobrenome] do filho n° "),
    ULTIMO_NOME("Digite o [Ultimo nome] do filho n° "),
    CPF("DIGITE O N° DO SEU CPF "),
    QUANTIDADE_FILHO(" Digite a quantidade de filhos para o cadastro "),
    N_VALIDO("Insira um numero valido !"),
    N_INVALIDO("Numero invalido !"),
    INSIRA_NUMERO("INSIRA UM NUMERO DE TELEFONE"),
    NUMERO_SUCESSO("Numero inserido com sucesso !"),
    PRESS_ENTER("PRESS ENTER"),
    ADICIONE_OPCAO_VALIDA("Digite uma opção valida");

    private String descricao;

    MensagemEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}