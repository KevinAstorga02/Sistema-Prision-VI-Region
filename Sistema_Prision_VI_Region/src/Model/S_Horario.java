package Model;

import java.sql.Time;

public class S_Horario {
    private String tipo;
    private Time inicio_horario;
    private Time fin_horario;

    public S_Horario(String tipo, Time inicio_horario, Time fin_horario) {
        this.tipo = tipo;
        this.inicio_horario = inicio_horario;
        this.fin_horario = fin_horario;
    }

    public S_Horario() {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Time getInicio_horario() {
        return inicio_horario;
    }

    public void setInicio_horario(Time inicio_horario) {
        this.inicio_horario = inicio_horario;
    }

    public Time getFin_horario() {
        return fin_horario;
    }

    public void setFin_horario(Time fin_horario) {
        this.fin_horario = fin_horario;
    }
}
