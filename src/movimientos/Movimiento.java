package movimientos;

public abstract class Movimiento {

    private String nombreHabilidad;
    private int resistencia;

    Movimiento(String nombreHabilidad, int resistencia) {
        this.nombreHabilidad=nombreHabilidad;
        this.resistencia = resistencia;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void consumirResistencia() {

    }

}
