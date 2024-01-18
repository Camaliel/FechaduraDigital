package CadastrarSenha.Service;

import java.util.Random;

public class ChaveToken {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    static String token;

    public String getPegaToken() {
        return pegaToken;
    }

    String pegaToken = String.format("%06d", new Random().nextInt(999999));

    public String getPegaRoleta() {
        return pegaToken;
    }

    public void setPegaRoleta(String pegaToken) {
        this.pegaToken = pegaToken;
    }

}