package movimientos;

import combate.Estado;
import pokemon.Pokemon;

public class MovEstadoAplicarElem extends MovimientoEstado {

    // Torbellino, mojado, electrificado, enfriado
    private Estado elemento;

    public MovEstadoAplicarElem(String nombreHabilidad, int resistencia, Estado estado) {
        super(nombreHabilidad, resistencia, estado);
        // TODO Auto-generated constructor stub
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
