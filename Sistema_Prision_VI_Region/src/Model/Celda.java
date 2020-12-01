package Model;

public class Celda {
    private Integer celda_num;
    private Integer cantidad_actual;
    private Integer FK_p_sector;

    public Celda(Integer celda_num, Integer cantidad_actual, Integer FK_p_sector) {
        this.celda_num = celda_num;
        this.cantidad_actual = cantidad_actual;
        this.FK_p_sector = FK_p_sector;
    }

    public Celda() {

    }

    public Integer getCelda_num() {
        return celda_num;
    }

    public void setCelda_num(Integer celda_num) {
        this.celda_num = celda_num;
    }

    public Integer getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(Integer cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public Integer getFK_p_sector() {
        return FK_p_sector;
    }

    public void setFK_p_sector(Integer FK_p_sector) {
        this.FK_p_sector = FK_p_sector;
    }
}
