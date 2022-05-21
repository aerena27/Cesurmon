package movimientos;

import combate.Estado;
import combate.Tipo;
import pokemon.Pokemon;

public class MovEstadoAturdir extends MovimientoEstado {

    // Dormir, petrificar, congelar
    private int turnosParado; // bajan en cada turno

    public MovEstadoAturdir(Tipo tipo, String nombreHabilidad, int resistencia, Estado estado, int turnosParado) {
        super(tipo, nombreHabilidad, resistencia, estado);
        this.turnosParado = turnosParado;

    }

    public int getTurnosParado() {
        return turnosParado;
    }

    public void setTurnosParado(int turnosParado) {
        this.turnosParado = turnosParado;
    }

    /**
     * Los estados Aturdir alteran la capacidad de uso de movimientos en el rival,
     * inflingiendo un estado y la cantidad de turnos sin poder ejecutar un
     * movimiento.
     */
    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        defensor.setEstado(getEstado());
        defensor.setTurnosParado(turnosParado);
        // TODO: Añadirlos al controlador o combate
    }

}
