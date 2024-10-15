package CadastrarSenha.Entities;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4570350920365851334L;

    int Id;
    Date dia;
    Date hora;
    String parentesco;
    String Status;


    public Date getDia() {
        return dia;
    }

    public Date setDia(SimpleDateFormat dia) {
        this.dia = dia.get2DigitYearStart();
        return null;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getHora(SimpleDateFormat horaAtual) {
        return hora;
    }

    public Date setHora(SimpleDateFormat hora) {
        this.hora = hora.get2DigitYearStart();
        return null;
    }

    public String getParentesco() {
        return parentesco;
    }

    public String setParentesco(String parentesco) {
        this.parentesco = parentesco;
        return parentesco;
    }

    public String getStatus() {
        return Status;
    }

    public String setStatus(String status) {
        Status = status;
        return status;
    }
}
