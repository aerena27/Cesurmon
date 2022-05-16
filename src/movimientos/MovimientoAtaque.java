package movimientos;

public abstract class MovimientoAtaque extends Movimiento {

    private int potencia;

    public MovimientoAtaque(String nombreHabilidad, int resistencia, int potencia) {
        super(nombreHabilidad, resistencia);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    

}
