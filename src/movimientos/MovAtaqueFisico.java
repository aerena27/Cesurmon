package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovAtaqueFisico extends MovimientoAtaque {

    public MovAtaqueFisico(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia, potencia);

    }

    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {
        if (checkResistencia(atacante) == true) {
            float potenciadorTipoPropio = calcularStab(atacante);
            float potenciadorTipoRival = logicaTipos(defensor);
            int danioTotal = (int) ((getPotencia() * atacante.getAtaqueFisico() * potenciadorTipoPropio
                    * potenciadorTipoRival) - defensor.getDefensaFisica());

            int vidaDefensor = defensor.getPuntosSaludCombate() - danioTotal;
            corregirVitalidadNegativa(vidaDefensor, defensor);
            consumirResistencia(atacante);
        }
    }

}
