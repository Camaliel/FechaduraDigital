package CadastrarSenha.Service;

import java.io.Serializable;

public class ListaTelegram implements Serializable {
    public String setParentesco(String parentesco) {
        this.parentesco = parentesco;
        return parentesco;
    }

    public String parentesco = "";

    public String getParentesco() {
        return parentesco;
    }
}
