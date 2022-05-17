package combate;

import pokemon.Entrenador;

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

    public void mensajeAtacante(Entrenador atacante, float ataque) {
        System.out.println("El ataque de " + atacante.getEquipo1().getNombreEspecie() + " es: " + ataque);
    }

    public void mensajeDefensor(Entrenador defensor, float vida) {
        System.out.println("La vida de " + defensor.getEquipo1().getNombreEspecie() + " es: " + vida);
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
