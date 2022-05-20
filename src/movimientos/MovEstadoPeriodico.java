package movimientos;

import combate.Estado;
import combate.Tipo;
import pokemon.Pokemon;

public class MovEstadoPeriodico extends MovimientoEstado {

    // Quemado, electrocargado

    public MovEstadoPeriodico(Tipo tipo, String nombreHabilidad, int resistencia, Estado estado) {
        super(null, nombreHabilidad, resistencia, estado);
    }

    /**
     * Los estados Periódicos bajan ligeramente la vida del portador al final de un
     * turno.
     */
    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        defensor.setEstado(getEstado());
        // TODO: Programar la lógica en el combate o controlador
    }

}
