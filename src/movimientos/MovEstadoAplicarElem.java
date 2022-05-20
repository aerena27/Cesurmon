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

    /**
     * Los estados de Aplicar elemento son cosméticos, solo cambian el estado
     * visualmente, pero no alteran las estadísticas, excepto Anemo (volador), que
     * al entrar en contacto con otro estado, lo anula.
     */
    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        if (this.elemento.equals(Estado.TORBELLINO)) {
            defensor.setEstado(Estado.SIN_ESTADO);
        } else {
            defensor.setEstado(elemento); // Estados comésticos, no hacen nada
        }
    }

}
