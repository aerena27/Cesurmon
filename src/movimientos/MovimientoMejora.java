package movimientos;

import combate.Tipo;

public abstract class MovimientoMejora extends Movimiento {

    private int turnosMejora;

    public MovimientoMejora(Tipo tipo, String nombreHabilidad, int resistencia, int turnosMejora) {
        super(null, nombreHabilidad, resistencia);
        this.turnosMejora = turnosMejora;
    }

    public int getTurnosMejora() {
        return turnosMejora;
    }

    public void setTurnosMejora(int turnosMejora) {
        this.turnosMejora = turnosMejora;
    }
}
