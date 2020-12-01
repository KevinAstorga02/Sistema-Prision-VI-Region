package Model;

public class Condena {
    private String rut;
    private Integer P_anos;
    private String descripcion;

    public Condena(String rut, Integer p_anos, String descripcion) {
        this.rut = rut;
        P_anos = p_anos;
        this.descripcion = descripcion;
    }

    public Condena() {

    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getP_anos() {
        return P_anos;
    }

    public void setP_anos(Integer p_anos) {
        P_anos = p_anos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
