package movimientos;

import combate.Estado;

public abstract class MovimientoEstado extends Movimiento {

    private Estado estado;

    public MovimientoEstado(String nombreHabilidad, int resistencia, Estado estado) {
        super(nombreHabilidad, resistencia);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
