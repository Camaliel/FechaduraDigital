package CadastrarSenha.Enum;

public enum MensagemEnum {
    PATRIARCA("Voce e o patriarca ?"),
    MATRIARCA("Voce e a Matriarca ?"),
    E_ENVIADO("Email enviado"),
    E_ENVIANDO("Enviando email"),
    N_VALIDO("Insira um numero valido !"),
    N_INVALIDO("Numero valido !"),
    N_ADICIONADO("Adicionado ao banco de dados");


    MensagemEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    private String descricao;
}
