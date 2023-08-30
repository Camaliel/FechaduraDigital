package CadastrarSenha;

public class Variaveis {
    public Variaveis(String pai) {
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

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getFilho() {
        return filho;
    }

    public void setFilho(String filho) {
        this.filho = filho;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public Variaveis() {
    }
}
