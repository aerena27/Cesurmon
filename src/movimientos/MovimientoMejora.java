package movimientos;

public abstract class MovimientoMejora extends Movimiento {

    private int mejora;
    private Estadistica estadistica;

    public MovimientoMejora(String nombreHabilidad, int resistencia, int mejora) {
        super(nombreHabilidad, resistencia);
        this.mejora = mejora;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }
}
