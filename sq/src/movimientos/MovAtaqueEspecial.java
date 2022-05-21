package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public class MovAtaqueEspecial extends MovimientoAtaque {

    public MovAtaqueEspecial(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia, potencia);

    }


    @Override
    public float calcularAtaque(Pokemon atacante) {

        return (float)atacante.getAtaqueEspecial();
    }

    @Override
    public float calcularDefensa(Pokemon defensor) {

        return (float)defensor.getDefensaEspecial();
    }

}
