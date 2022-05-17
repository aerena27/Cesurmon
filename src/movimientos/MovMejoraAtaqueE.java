package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovMejoraAtaqueE extends MovimientoMejora {

    public MovMejoraAtaqueE(Tipo tipo, String nombreHabilidad, int resistencia, int mejora) {
        super(null, nombreHabilidad, resistencia, mejora);
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        
    }
    
}
