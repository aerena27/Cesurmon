package movimientos;

public abstract class MovimientoMejora extends Movimiento {

    private int turnosMejora;

    public MovimientoMejora(String nombreHabilidad, int resistencia, int turnosMejora) {
        super(nombreHabilidad, resistencia);
        this.turnosMejora = turnosMejora;
    }

    public int getTurnosMejora() {
        return turnosMejora;
    }

    public void setTurnosMejora(int turnosMejora) {
        this.turnosMejora = turnosMejora;
    }
}
