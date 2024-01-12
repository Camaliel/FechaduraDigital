package CadastrarSenha.jdbc.Entity;

import java.util.Random;

public class ChaveToken {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    static String token;

    public String getTesteRoleta() {
        return testeRoleta;
    }

    String testeRoleta = String.format("%06d", new Random().nextInt(999999));

    public String getPegaRoleta() {
        return pegaRoleta;
    }

    String pegaRoleta = testeRoleta;
}