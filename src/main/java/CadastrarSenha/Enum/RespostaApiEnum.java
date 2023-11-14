package CadastrarSenha.Enum;

public enum RespostaApiEnum {
    SEM_FUNCIONALIDADE("Estou sem funcionalidade ...Peladinho da Silva"),
    NAO_ENTENDO_SUA_LINGUAGEM_DE_PROGRAMACAO("Ainda não entendo o que isso significa.. mas estou estudando " +
            "muito pra poder entender sua linguagem de programação e assim conversamos muito"),
    TESTE_BOT("Testando escrita do bot"),
    APRENDENDO("Estou empenhado em aprender sua linguagem de programação, cada dia um novo aprendizado .. bip bip");

    String descricao;

    public String getDescricao() {
        return descricao;
    }


    RespostaApiEnum(String descricao) {
        this.descricao = descricao;
    }
}
