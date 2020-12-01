package Model;

public class Delitos {
    private String nombre;
    private String descripcion;
    private String anos_prision;

    public Delitos(String nombre, String descripcion, String anos_prision) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anos_prision = anos_prision;
    }

    public Delitos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnos_prision() {
        return anos_prision;
    }

    public void setAnos_prision(String anos_prision) {
        this.anos_prision = anos_prision;
    }
}
