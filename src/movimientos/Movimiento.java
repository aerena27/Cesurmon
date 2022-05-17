package movimientos;

import combate.Tipo;
import pokemon.Pokemon;

public abstract class Movimiento {

    private Tipo tipo;
    private String nombreHabilidad;
    private int resistencia;

    Movimiento(Tipo tipo, String nombreHabilidad, int resistencia) {
        this.nombreHabilidad = nombreHabilidad;
        this.resistencia = resistencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void consumirResistencia() {

    }

    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {

    }

}
