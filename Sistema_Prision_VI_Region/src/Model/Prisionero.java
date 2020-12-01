package Model;

public class Prisionero extends Persona{
    private Integer celda;

    public Prisionero(String rut, String nombre, String apellido, Integer edad, Integer celda) {
        super(rut, nombre, apellido, edad);
        this.celda = celda;
    }

    public Integer getCelda() {
        return celda;
    }

    public void setCelda(Integer celda) {
        this.celda = celda;
    }
}
