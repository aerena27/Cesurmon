package movimientos;

import combate.Estado;
import pokemon.Pokemon;

public class MovEstadoAturdir extends MovimientoEstado {

    // Dormir, petrificar, congelar
    private int turnosParado; // bajan en cada turno

    public MovEstadoAturdir(String nombreHabilidad, int resistencia, Estado estado, int turnosParado) {
        super(nombreHabilidad, resistencia, estado);
        this.turnosParado = turnosParado;

    }

    public int getTurnosParado() {
        return turnosParado;
    }

    public void setTurnosParado(int turnosParado) {
        this.turnosParado = turnosParado;
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        defensor.setEstado(getEstado());
        defensor.setTurnosParado(turnosParado);
    }

}
