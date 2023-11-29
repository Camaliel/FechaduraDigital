package CadastrarSenha.Util.Variavel;

public class InfoUsuario {
    String cpf;
    int Dnascimento;

    String numeroCelular;

    String senha;

    public String getSenha() {
        return senha;
    }

    public String setSenha(String senha) {
        this.senha = senha;
        return senha;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
        return numeroCelular;
    }

    public String getCpf() {
        return cpf;
    }

    public String setCpf(String cpf) {
        this.cpf = cpf;
        return cpf;
    }

    public int getDnascimento() {
        return Dnascimento;
    }

    public void setDnascimento(int dnascimento) {
        Dnascimento = dnascimento;
    }


}
