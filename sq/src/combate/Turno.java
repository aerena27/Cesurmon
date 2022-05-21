package combate;

import movimientos.Movimiento;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class Turno {

    private int numeroTurno;
    private String accionEntrenador;
    private String accionRival;
    Entrenador atacante;
    Entrenador defensor;

    public Turno(int numeroTurno, String accionEntrenador, String accionRival) {
        numeroTurno = 0;
        this.accionEntrenador = accionEntrenador;
        this.accionRival = accionRival;
    }

    public String mensajeAtacanteLog(Pokemon pokeAtacante, Movimiento movimiento) {
		return pokeAtacante.getNombreEspecie() + " ha usado " + movimiento.getNombreHabilidad();
	}

    public void mensajeDefensor(Entrenador defensor, float vida) {
        // System.out.println("La vida de " + defensor.getEquipo1().getNombreEspecie() +
        // " es: " + vida);
    }

    public void mostrarGanador(Entrenador ganador) {
        System.out.println("El ganador es: " + ganador.getNombre());
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
