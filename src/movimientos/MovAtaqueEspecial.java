package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovAtaqueEspecial extends MovimientoAtaque {

    public MovAtaqueEspecial(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia, potencia);

    }

    /**
     * Coge todos los atributos calculados de métodos heredados para calcular el
     * daño total que se ejecutará. A partir de este, se calcula la vitalidad final
     * del defensor, corrigiéndola y haciéndole set.
     */
    @Override
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {

        // Se comprueba si el Pokémon atacante no está debilitado
        if (puedeAtacar(atacante) == true) {
            // Se comprueba si el atacante tiene estamina suficiente
            if (checkResistencia(atacante) == true) {
                consumirResistencia(atacante);
                float potenciadorTipoPropio = calcularStab(atacante);
                float potenciadorTipoRival = logicaTipos(defensor);
                // Se calcula y corrige la vida final del defensor
                int danioTotal = (int) ((getPotencia() * atacante.getAtaqueEspecial() * potenciadorTipoPropio
                        * potenciadorTipoRival) - defensor.getDefensaEspecial());

                int vidaDefensor = defensor.getPuntosSaludCombate() - danioTotal;
                corregirVitalidadNegativa(vidaDefensor, defensor);
            }
        }
    }

}
