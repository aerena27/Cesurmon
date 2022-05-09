package pokemon;

public class MovimientoAtaque extends Movimiento {

    private int potencia;
    private boolean esFisico; // físico o especial

    public MovimientoAtaque(int resistencia, int potencia, boolean esFisico) {
        super(resistencia);
        this.potencia = potencia;
        this.esFisico = esFisico;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean getEsFisico() {
        return esFisico;
    }

    public void setEsFisico(boolean esFisico) {
        this.esFisico = esFisico;
    }
    

}
