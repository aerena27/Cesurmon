package movimientos;

import combate.Estado;

public class MovimientoEstado extends Movimiento {

    private Estado estado;

    public MovimientoEstado(int resistencia, Estado estado) {
        super(resistencia);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
