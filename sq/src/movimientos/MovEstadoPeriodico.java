package movimientos;

import combate.Estado;
import combate.Tipo;
import pokemon.Pokemon;

public class MovEstadoPeriodico extends MovimientoEstado {

    // Quemado, electrocargado

    public MovEstadoPeriodico(Tipo tipo, String nombreHabilidad, int resistencia, Estado estado) {
        super(tipo, nombreHabilidad, resistencia, estado);
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        defensor.setEstado(getEstado());
    
    }

}
