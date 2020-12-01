package Model;

public class Guardia extends Persona {

    private String rango;
    private String contrasena;
    private String sector;

    public Guardia(String rut, String nombre, String apellido, Integer edad, String rango, String contrasena, String sector) {
        super(rut, nombre, apellido, edad);
        this.rango = rango;
        this.contrasena = contrasena;
        this.sector = sector;
    }

    public Guardia() {

    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
