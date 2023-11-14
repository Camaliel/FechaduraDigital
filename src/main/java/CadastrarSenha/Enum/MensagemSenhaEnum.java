package CadastrarSenha.Enum;

public enum MensagemSenhaEnum {
    CADASTRE_SENHA("CADASTRE UMA SENHA"),
    SENHA_CADASTRADA("Senha cadastrada"),
    ERRO_SENHA("Erro, escolha uma senha com pelo menos 6 digitos");
    String descricao;


    MensagemSenhaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
