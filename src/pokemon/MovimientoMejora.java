package pokemon;

public class MovimientoMejora extends Movimiento {

    private int mejora;
    private Estadistica estadistica;

    MovimientoMejora(Tipo tipo, int resistencia, int mejora, Estadistica estadistica) {
        super(tipo, resistencia);
        this.mejora = mejora;
        this.estadistica = estadistica;
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
