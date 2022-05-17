package movimientos;

import combate.Estado;
import combate.Tipo;
import pokemon.Pokemon;

public class MovEstadoAplicarElem extends MovimientoEstado {

    // Torbellino, mojado, electrificado, enfriado
    private Estado elemento;

    public MovEstadoAplicarElem(Tipo tipo, String nombreHabilidad, int resistencia, Estado estado) {
        super(tipo, nombreHabilidad, resistencia, estado);
        
    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        if (this.elemento.equals(Estado.TORBELLINO)) {
            defensor.setEstado(Estado.SIN_ESTADO);
        } else {
            defensor.setEstado(elemento); // Estados comésticos, no hacen nada
        }
    }

}
