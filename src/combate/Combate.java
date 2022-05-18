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
	private int koJugador;
	private int koRival;
	public static final String PATH_LOG = "./log/combate.log";

	public Combate(Entrenador jugador, Entrenador rival, int koJugador, int koRival) {
		super();
		numeroTurno = 0;
		turnos = new LinkedList<>();
		this.jugador = jugador;
		this.rival = rival;
		this.koJugador = koJugador;
		this.koRival = koRival;
	}

	// Método donde se realice todo el combate en su totalidad en bucle
	public void iniciarCombate() {

		// Grabar los logs acá
	}

	// Método donde se realizará la acción de todo el turno
	public void combatir(Entrenador atacante, Entrenador defensor) {

		// TODO: Comprobar qué velocidad es mayor para quién empieza antes
		// TODO: Toda la acción de usar movimientos

		Pokemon pokeAtacante = atacante.sacarPokemon();
		Pokemon pokeDefensor = defensor.sacarPokemon();
		Movimiento movimientoAtacante;
		Movimiento movimientoDefensor;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el movimiento que quieres que " + pokeAtacante
				+ " use (1, 2, 3, 4)");
		movimientoAtacante = pokeAtacante.getMovimiento(sc.nextInt() - 1);
		sc.close();

		System.out.println(mensajeAtacante(pokeAtacante, movimientoAtacante));
	
	}

	public String mensajeAtacante(Pokemon pokeAtacante, Movimiento movimiento) {
		return "¡" + pokeAtacante.getNombreEspecie() + " ha usado " + movimiento.getNombreHabilidad() + "!";
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