package CadastrarSenha.Enum;

public enum Mensagem {
 E_ENVIADO("Email enviado"),
 E_ENVIANDO("Enviando email");


    Mensagem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    private String descricao;
}
