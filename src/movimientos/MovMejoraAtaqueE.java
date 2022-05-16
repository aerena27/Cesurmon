package movimientos;

import pokemon.Pokemon;

public class MovMejoraAtaqueE extends MovimientoMejora {

    public MovMejoraAtaqueE(String nombreHabilidad, int resistencia, int mejora) {
        super(nombreHabilidad, resistencia, mejora);
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        
    }
    
}
