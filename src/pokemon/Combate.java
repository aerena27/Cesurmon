package pokemon;

public class Combate {

	private int turno;
	private Entrenador jugador;
	private Entrenador rival;
	private int koJugador;
	private int koRival;
	private Efectividad efectividadMov;

	public Combate(int turno, Entrenador jugador, Entrenador rival, int koJugador, int koRival,
			Efectividad efectividadMov) {
		super();
		this.turno = turno;
		this.jugador = jugador;
		this.rival = rival;
		this.koJugador = koJugador;
		this.koRival = koRival;
		this.efectividadMov = efectividadMov;
	}

	public void combatir(Entrenador atacante, Entrenador defensor) {

		this.turno++;
		System.out.println("Turno: " + turno);
		float ataque = atacante.getEquipo1().getAtaqueFisico() * (1 + atacante.getEquipo1().getAtaqueEspecial());
		System.out.println("El ataque de " + atacante.getEquipo1().getNombreEspecie() + " es: " + ataque);
		float defensa = defensor.getEquipo1().getDefensaFisica() * (1 + defensor.getEquipo1().getDefensaEspecial());
		float vida = defensor.getEquipo1().getPuntosSalud() * (1 + defensor.getEquipo1().getNivel());
		System.out.println("La vida de " + defensor.getEquipo1().getNombreEspecie() + " es: " + vida);
		vida = vida - (ataque - defensa);

		System.out.println("La vida de " + defensor.getEquipo1().getNombreEspecie() + " es: " + vida);
		System.out.println("El ganador es: " + mostrarGanador(atacante));
	}

	public String mostrarGanador(Entrenador ganador) {
		return ganador.getNombre();
	}

	public void logicaEfectividad() {

	}

	public void logicaTipos() {

	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Entrenador getJugador() {
		return jugador;
	}

	public void setJugador(Entrenador jugador) {
		this.jugador = jugador;
	}

	public Entrenador getRival() {
		return rival;
	}

	public void setRival(Entrenador rival) {
		this.rival = rival;
	}

	public int getKoJugador() {
		return koJugador;
	}

	public void setKoJugador(int koJugador) {
		this.koJugador = koJugador;
	}

	public int getKoRival() {
		return koRival;
	}

	public void setKoRival(int koRival) {
		this.koRival = koRival;
	}

	public Efectividad getEfectividadMov() {
		return efectividadMov;
	}

	public void setEfectividadMov(Efectividad efectividadMov) {
		this.efectividadMov = efectividadMov;
	}

}