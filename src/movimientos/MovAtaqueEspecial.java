package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovAtaqueEspecial extends MovimientoAtaque {

    public MovAtaqueEspecial(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia, potencia);

    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        float potenciadorTipoPropio = calcularStab(atacante);
        float potenciadorTipoRival = logicaTipos(defensor);
        int danioTotal = (int) ((getPotencia() * atacante.getAtaqueEspecial() * potenciadorTipoPropio
                * potenciadorTipoRival) - defensor.getDefensaEspecial());

        int vidaDefensor = defensor.getPuntosSaludCombate() - danioTotal;
        corregirVitalidadNegativa(vidaDefensor, defensor);
    }

}
