package CadastrarSenha.Variaveis;

public class InfoUsuario {
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    String cpf;
    int Dnascimento;
    int numeroCelular;

    public int getDnascimento() {
        return Dnascimento;
    }

    public void setDnascimento(int dnascimento) {
        Dnascimento = dnascimento;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
