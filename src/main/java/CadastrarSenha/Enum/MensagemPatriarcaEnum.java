package CadastrarSenha.Enum;

public enum MensagemPatriarcaEnum {
    MATRIARCA("Voce e a Matriarca ?"),
    PATRIARCA("Voce e o patriarca ?");
    private String descricao;

    MensagemPatriarcaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
