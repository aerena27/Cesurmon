package pokemon;

public class MovimientoEstado extends Movimiento {

    private Estado estado;

    public MovimientoEstado(Tipo tipo, int resistencia, Estado estado) {
        super(tipo, resistencia);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
