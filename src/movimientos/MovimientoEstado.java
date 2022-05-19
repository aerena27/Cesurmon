package movimientos;

import combate.Estado;
import combate.Tipo;

public abstract class MovimientoEstado extends Movimiento {

    private Estado estado;

    public MovimientoEstado(Tipo tipo, String nombreHabilidad, int resistencia, Estado estado) {
        super(tipo, nombreHabilidad, resistencia);
        this.tipo = tipo;
        this.nombreHabilidad = nombreHabilidad;
        this.resistencia = resistencia;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
