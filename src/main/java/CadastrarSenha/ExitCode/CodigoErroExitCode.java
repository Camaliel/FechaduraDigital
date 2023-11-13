package CadastrarSenha.ExitCode;

public enum CodigoErroExitCode {
   COD_0("Ja existe um usuario admin."),
    COD_1("Erro de envio.");

    public String descricao;

    public String getDescricao() {
        return descricao;
    }

    CodigoErroExitCode(String descricao) {
        this.descricao = descricao;
    }


}
