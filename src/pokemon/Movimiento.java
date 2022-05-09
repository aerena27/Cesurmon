package pokemon;

public class Movimiento {

    private Tipo tipo;
    private int resistencia;

    Movimiento(Tipo tipo, int resistencia) {
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void consumirResistencia() {

    }

}
