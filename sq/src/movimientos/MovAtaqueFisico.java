package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovAtaqueFisico extends MovimientoAtaque {

    public MovAtaqueFisico(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia, potencia);

    }


    @Override
    public float calcularAtaque(Pokemon atacante) {

        return (float)atacante.getAtaqueFisico();
    }

    @Override
    public float calcularDefensa(Pokemon defensor) {

        return (float)defensor.getDefensaFisica();
    }

}
