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

	private List<Turno> turnos;
	private int numeroTurno;
	private Entrenador jugador;
	private Entrenador rival;
	private Entrenador ganador;
	private Pokemon pokeJugador;
	private Pokemon pokeRival;
	private int koJugador;
	private int koRival;
	private int contadorVictorias;

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

	// Método donde se realizará la acción de todo el turno
	public void realizarTurno(Entrenador usuario, Entrenador rival, Movimiento moviUsuario,
			Movimiento moviRival) {

		Pokemon pokeUsuario = usuario.sacarPokemon();
		Pokemon pokeRival = rival.sacarPokemon();
		Movimiento movimientoUsuario = moviUsuario;
		Movimiento movimientoRival = moviRival;

		if (pokeUsuario.getVelocidad() >= pokeRival.getVelocidad()) {
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
		} else {
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
		}

		setNumeroTurno(getNumeroTurno() + 1);

		String accionUsuario = pokeUsuario.getNombreEspecie() + " ha usado "
				+ moviUsuario.getNombreHabilidad();
		String acccionRival = pokeRival.getNombreEspecie() + " ha usado "
				+ movimientoRival.getNombreHabilidad();
		Turno turno = new Turno(getNumeroTurno() - 1, accionUsuario, acccionRival);
		turnos.add(turno);
		checkKO(pokeUsuario, pokeRival);

	}

	public void checkKO(Pokemon pokeUsuario, Pokemon pokeRival) {
		if (pokeUsuario.getPuntosSaludCombate() == 0) {
			setKoJugador(this.koJugador + 1);
		}
		if (pokeRival.getPuntosSaludCombate() == 0) {
			setKoRival(this.koRival + 1);
		}
		if (this.koJugador == 4 && this.koRival < 4) {
			setGanador(rival);
			refrescarCombate();
		} else if (this.koJugador < 4 && this.koRival == 4) {
			setGanador(jugador);
			refrescarCombate();
		} else if (this.koJugador == 4 && this.koRival == 4) {
			setGanador(rival);
			refrescarCombate();
		}
	}

	public String devolverGanador() {
		if (this.ganador != null) {
			return "¡Ha ganado " + ganador.getNombre() + "!";
		} else {
			return "";
		}
	}

	public void refrescarCombate() {
		setKoJugador(0);
		setKoRival(0);
		escribirCombate();
		setNumeroTurno(1);
		setContadorVictorias(getContadorVictorias() + 1);
		for (int i = 0; i < this.jugador.getEquipo1().size(); i++) {
			jugador.getPokemon(i).revivir();
		}
		for (int i = 0; i < this.rival.getEquipo1().size(); i++) {
			rival.getPokemon(i).revivir();
			rival.generarEquipo(); // TODO: Programar el método
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