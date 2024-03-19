package CadastrarSenha.Enum;

public enum MensagemEnum {


    E_ENVIANDO("Enviando email"),
    ADICIONADO_AO_BANCO("Adicionado ao banco de dados"),
    NAO_ADICIONADO_AO_BANCO("Não enviado ao banco"),
    NOME_FILHO("Digite o nome filho n° "),
    CPF_FILHO("Agora, digite o CPF do filho n° "),
    CPF("DIGITE O N° DO SEU CPF "),
    CPF_PAI("Digite o n° do CPF do Pai"),
    QUANTIDADE_FILHO(" Digite a quantidade de filhos para o cadastro "),
    N_VALIDO("Insira um numero valido !"),
    N_INVALIDO("Numero invalido !"),
    INSIRA_NUMERO("INSIRA UM NUMERO DE TELEFONE"),
    NUMERO_SUCESSO("Numero inserido com sucesso !"),
    N_ADICIONADO("Numero adicionado ao banco de dados");

    private String descricao;

    MensagemEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
