package movimientos;

import combate.Estado;
import pokemon.Pokemon;

public class MovEstadoPeriodico extends MovimientoEstado {

    // Quemado, electrocargado

    public MovEstadoPeriodico(String nombreHabilidad, int resistencia, Estado estado) {
        super(nombreHabilidad, resistencia, estado);
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        defensor.setEstado(getEstado());
    
    }

}
