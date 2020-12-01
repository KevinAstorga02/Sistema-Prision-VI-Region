package Model;

import java.time.LocalDateTime;

public class Turnos {
    private String tipo;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;

    public Turnos(String tipo, LocalDateTime hora_inicio, LocalDateTime hora_fin) {
        this.tipo = tipo;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Turnos() {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalDateTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalDateTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalDateTime hora_fin) {
        this.hora_fin = hora_fin;
    }
}
