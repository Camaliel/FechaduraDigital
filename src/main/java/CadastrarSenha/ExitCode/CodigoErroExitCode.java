package CadastrarSenha.ExitCode;

public enum CodigoErroExitCode {
   COD_0("Ja existe um usuario admin."),
    COD_1("Erro de envio."),
   COD_2("CPF invalido"),
   COD_3("CPF, digito faltando");

    public String descricao;

    public String getDescricao() {
        return descricao;
    }

    CodigoErroExitCode(String descricao) {
        this.descricao = descricao;
    }


}
