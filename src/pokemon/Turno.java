package pokemon;

public class Turno {
    
    private int numeroTurno;
    Entrenador atacante;
    Entrenador defensor;


    public Turno (Entrenador atacante, Entrenador defensor) {
        numeroTurno=0;
        this.atacante=atacante;
        this.defensor=defensor;
    }

    public void mensajeAtacante(Entrenador atacante, float ataque){
        System.out.println("El ataque de " + atacante.getEquipo1().getNombreEspecie() + " es: " + ataque);
    }

    public void mensajeDefensor(Entrenador defensor, float vida){
        System.out.println("La vida de " + defensor.getEquipo1().getNombreEspecie() + " es: " + vida);
    }

    public void mostrarGanador(Entrenador ganador) {
		System.out.println("El ganador es: "+ ganador.getNombre());
	}

    public void getNumeroTurno() {
        System.out.println("Turno: "+ numeroTurno);
    }

    public void incrementoTurno() {
        this.numeroTurno++;
    }
}
