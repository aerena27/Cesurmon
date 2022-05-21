package combate;

import movimientos.Movimiento;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class Turno {

    /**
     * Los turnos solamente almacenarán información relacionada con los logs
     */

    private int numeroTurno; // Turno que se muestre en el log
    private String accionEntrenador; // Acción que se muestre en el log
    private String accionRival; // Acción que se muestre en el log

    public Turno(int numeroTurno, String accionEntrenador, String accionRival) {
        this.numeroTurno = numeroTurno;
        this.accionEntrenador = accionEntrenador;
        this.accionRival = accionRival;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public String getAccionEntrenador() {
        return accionEntrenador;
    }

    public void setAccionEntrenador(String accionEntrenador) {
        this.accionEntrenador = accionEntrenador;
    }

    public String getAccionRival() {
        return accionRival;
    }

    public void setAccionRival(String accionRival) {
        this.accionRival = accionRival;
    }

    public void incrementoTurno() {
        this.numeroTurno++;
    }
}
