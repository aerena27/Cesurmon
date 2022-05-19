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
	private int koJugador;
	private int koRival;
	public static final String PATH_LOG = "./log/combate.log";

	public Combate(Entrenador jugador, Entrenador rival) {
		super();
		numeroTurno = 0;
		turnos = new LinkedList<>();
		this.jugador = jugador;
		this.rival = rival;
		this.koJugador = 0;
		this.koRival = 0;
		this.ganador = null;
	}

	// Método donde se realizará la acción de todo el turno
	public void realizarTurno(Entrenador usuario, Entrenador rival, Movimiento moviUsuario,
			Movimiento moviRival) {

		Pokemon pokeUsuario = usuario.sacarPokemon();
		Pokemon pokeRival = rival.sacarPokemon();
		Movimiento movimientoUsuario = moviUsuario;
		Movimiento movimientoRival = moviRival;

		setNumeroTurno(this.numeroTurno++);
		String accionUsuario = pokeUsuario.getNombreEspecie() + " ha usado "
				+ moviUsuario.getNombreHabilidad();
		String acccionRival = pokeRival.getNombreEspecie() + " ha usado "
				+ movimientoRival.getNombreHabilidad();
		Turno turno = new Turno(getNumeroTurno(), accionUsuario, acccionRival);

		if (pokeUsuario.getVelocidad() >= pokeRival.getVelocidad()) {
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
		} else {
			moviRival.usarMovimiento(pokeRival, pokeUsuario);
			movimientoUsuario.usarMovimiento(pokeUsuario, pokeRival);
		}
		turnos.add(turno);
		checkKO(pokeUsuario, pokeRival);

	}

	public void checkKO(Pokemon pokeUsuario, Pokemon pokeRival) {
		if (pokeUsuario.getPuntosSaludCombate() == 0) {
			setKoJugador(this.koJugador++);
		}
		if (pokeRival.getPuntosSaludCombate() == 0) {
			setKoRival(this.koRival++);
		}
		if (this.koJugador == 4 && this.koRival < 4) {
			setGanador(rival);
			refrescarCombate();
		} else if (this.koJugador < 4 && this.koRival == 4) {
			setGanador(jugador);
			refrescarCombate();
		} else {
			setGanador(jugador);
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

	public String mensajeAtaque(Pokemon pokeAtacante, Movimiento movimiento) {
		return "¡" + pokeAtacante.getNombreEspecie() + " ha usado " + movimiento.getNombreHabilidad() + "!";
	}

	public void refrescarCombate() {
		setKoJugador(0);
		setKoRival(0);
		escribirCombate();
		// TODO: Restaurar estadísticas de ambos equipos
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