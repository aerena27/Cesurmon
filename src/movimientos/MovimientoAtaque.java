package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public abstract class MovimientoAtaque extends Movimiento {

    private int potencia;

    public MovimientoAtaque(Tipo tipo, String nombreHabilidad, int resistencia, int potencia) {
        super(tipo, nombreHabilidad, resistencia);
        this.tipo = tipo;
        this.nombreHabilidad = nombreHabilidad;
        this.resistencia = resistencia;
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public float calcularStab(Pokemon atacante) { // Same-type attack bonus
        float potenciadorPropioTipo;
        if (getTipo().equals(atacante.getTipo1())) {
            potenciadorPropioTipo = 1.5f;
        } else {
            potenciadorPropioTipo = 1.0f;
        }
        return potenciadorPropioTipo;
    }

}
