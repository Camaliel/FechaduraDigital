package CadastrarSenha.Variaveis;

public class VarFamiliar {
    public VarFamiliar(String pai) {
        this.pai = pai;
    }

    private String pai;
    private String mae;
    private String filho;
    private String outros;

    public String getPai() {
        return pai;
    }

    public String setPai(String pai) {
        this.pai = pai;

        return pai;
    }

    public String getMae() {
        return mae;
    }

    public String setMae(String mae) {
        this.mae = mae;
        return mae;
    }

    public String getFilho() {
        return filho;
    }

    public String setFilho(String filho) {
        this.filho = filho;
        return filho;
    }

    public String getOutros() {
        return outros;
    }

    public String setOutros(String outros) {
        this.outros = outros;
        return outros;
    }

    public VarFamiliar() {
    }
}
