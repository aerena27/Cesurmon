package combate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import movimientos.MovMejoraAtaqueF;
import movimientos.Movimiento;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class Combate {

	private List<Turno> turnos;// Colección de turnos para el log
	private int numeroTurno; // Turno actual
	private Entrenador jugador; // Usuario
	private Entrenador rival; // Rival programa
	private Entrenador ganador;
	private Pokemon pokeJugador; // Pokémon escogido por el usuario
	private Pokemon pokeRival; // Pokémon escogido por el rival
	private int koJugador; // KOs del entrenador usuario
	private int koRival; // KOs del entrenador programa
	private int contadorVictorias; // Contador de victorias para la interfaz

	public static final String PATH_LOG = "./log/combate.log";

	public Combate(Entrenador jugador, Entrenador rival) {
		super();
		numeroTurno = 1;
		turnos = new LinkedList<>();
		this.jugador = jugador;
		this.rival = rival;
		this.koJugador = 0;
		this.koRival = 0;
		this.ganador = null;
		this.contadorVictorias = 0;
	}

	/**
	 * Método principal donde se realiza la acción de un turno. Calcula qué Pokémon
	 * de los entrenadores debe salir automáticamente por su vitalidad, comprueba la
	 * velocidad de ellos, escribe la acción del turno para el log, y comprueba el
	 * resultado final del turno
	 * 
	 * @param usuario     Entrenador usuario
	 * @param rival       Entrenador controlado por el programa
	 * @param moviUsuario Movimiento que ejecutará el usuario
	 * @param moviRival   Movimiento que ejecutará el programa
	 */
	public void realizarTurno(Entrenador usuario, Entrenador rival, Movimiento moviUsuario,
			Movimiento moviRival) {

		// Se calculan los Pokémon que deben salir al inicio del turno
		Pokemon pokeUsuario = usuario.sacarPokemon();
		Pokemon pokeRival = rival.sacarPokemon();
		Movimiento movimientoUsuario = moviUsuario;
		Movimiento movimientoRival = moviRival;

		// Se comprueba la velocidad y se ejecutan los movimientos que serán pasados por
		// parámetro mediante el botón de la interfaz
		if (pokeUsuario.getVelocidad() >= pokeRival.getVelocidad()) {
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
		} else {
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
		}
		// Incrementar el número de turno
		setNumeroTurno(getNumeroTurno() + 1);

		// Escribir las acciones que se han ejecutado
		String accionUsuario = pokeUsuario.getNombreEspecie() + " ha usado "
				+ moviUsuario.getNombreHabilidad();
		String acccionRival = pokeRival.getNombreEspecie() + " ha usado "
				+ movimientoRival.getNombreHabilidad();
		// Se añaden las acciones a un nuevo turno y se guarda en una lista
		Turno turno = new Turno(getNumeroTurno() - 1, accionUsuario, acccionRival);
		turnos.add(turno);
		// Se comprueba el estado del combate al finalizar el turno
		checkKO(pokeUsuario, pokeRival);

	}

	/**
	 * Método que comprueba qué Pokémon están debilitados al finalizar un turno,
	 * para aumentar el contador de ambos KO y en caso de haber llegado alguno a 4,
	 * el combate se reinicia para seguir luchando desde el principio.
	 * 
	 * @param pokeUsuario Pokémon controlado por el usuario
	 * @param pokeRival   Pokémon controlado por el programa
	 */
	public void checkKO(Pokemon pokeUsuario, Pokemon pokeRival) {
		// Comprobar si ambos están debilitados
		if (pokeUsuario.getPuntosSaludCombate() == 0) {
			setKoJugador(this.koJugador + 1);
		}
		if (pokeRival.getPuntosSaludCombate() == 0) {
			setKoRival(this.koRival + 1);
		}
		// Al haber llegado alguno a 4, se escoge un ganador y se reinicia el estado del
		// combate para comenzar uno nuevo
		if (this.koJugador == 4 && this.koRival < 4) { // Gana el programa
			setGanador(rival);
			refrescarCombate();
		} else if (this.koJugador < 4 && this.koRival == 4) { // Gana el usuario
			setGanador(jugador);
			setContadorVictorias(getContadorVictorias() + 1); // Incrementar victorias
			refrescarCombate();
		} else if (this.koJugador == 4 && this.koRival == 4) { // Empate
			setGanador(rival);
			refrescarCombate();
		}
	}

	/**
	 * Método que se ejecutará al haber derrotado alguno de los 2 equipos en
	 * combate, para resetear el estado del mismo y seguir luchando, además de
	 * escribirlo en un log.
	 */
	public void refrescarCombate() {
		// Se resetean los KO de ambos jugadores
		setKoJugador(0);
		setKoRival(0);
		// Se escribe en un log la colección de turnos almacenados. En caso de realizar
		// varios combates consecutivamente sin huir, se almacenarán en el mismo
		// fichero.
		escribirCombate();
		setNumeroTurno(1); // Ajustar el turno
		// Se recogen ambos equipos y se restauran las estadísticas variables de cada
		// uno de ellos para que puedan volver a combatir
		for (int i = 0; i < this.jugador.getEquipo1().size(); i++) {
			jugador.getPokemon(i).revivir();
		}
		for (int i = 0; i < this.rival.getEquipo1().size(); i++) {
			rival.getPokemon(i).revivir();
			rival.generarEquipo(); // TODO: Programar el método (opcional)
		}
	}

	/**
	 * Devolver el ganador de una ronda, asignado al llegar alguno de los
	 * entrenadores a 4 KO
	 * 
	 * @return
	 */
	public String devolverGanador() {
		if (this.ganador != null) {
			return "¡Ha ganado " + ganador.getNombre() + "!";
		} else {
			return "";
		}
	}

	public int getNumeroTurno() {
		return this.numeroTurno;
	}

	public void setNumeroTurno(int numeroTurno) {
		this.numeroTurno = numeroTurno;
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

	public Entrenador getGanador() {
		return ganador;
	}

	public void setGanador(Entrenador ganador) {
		this.ganador = ganador;
	}

	public int getContadorVictorias() {
		return contadorVictorias;
	}

	public void setContadorVictorias(int contadorVictorias) {
		this.contadorVictorias = contadorVictorias;
	}

	public Pokemon getPokeJugador() {
		return pokeJugador;
	}

	public void setPokeJugador(Pokemon pokeJugador) {
		this.pokeJugador = pokeJugador;
	}

	public Pokemon getPokeRival() {
		return pokeRival;
	}

	public void setPokeRival(Pokemon pokeRival) {
		this.pokeRival = pokeRival;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void addTurnos(Turno turno) {
		this.turnos.add(turno);
	}

	/**
	 * Método que recorre el array de turnos y lo escribe en un fichero aparte. Se
	 * escribirán todos los combates realizados consecutivamente hasta que se huya
	 * del combate.
	 */
	public void escribirCombate() {
		File fichero = new File(PATH_LOG);
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Turno turno : turnos) {
				bw.write("Turno: " + turno.getNumeroTurno() + "\n");
				bw.write("Entrenador: " + turno.getAccionEntrenador() + "\n");
				bw.write("Rival: " + turno.getAccionRival() + "\n");
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}