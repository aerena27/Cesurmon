package movimientos;

import pokemon.Pokemon;

public abstract class Movimiento {

    private String nombreHabilidad;
    private int resistencia;

    Movimiento(String nombreHabilidad, int resistencia) {
        this.nombreHabilidad=nombreHabilidad;
        this.resistencia = resistencia;
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
