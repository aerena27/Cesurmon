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

	// Método donde se realice todo el combate en su totalidad
	public void iniciarCombate() {

		// Grabar los logs acá
	}

	// Método donde se realizará la acción de todo el turno
	public void combatir(Entrenador atacante, Entrenador defensor) {

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
		// float ataque = 0;

		// if (((MovimientoAtaque)
		// atacante.getEquipo1().getMovimientos(movimientoAtacante)).getEsFisico())
		// ataque = (atacante.getEquipo1().getAtaqueFisico()) * (1 +
		// atacante.getEquipo1().getAtaqueEspecial());
		// else
		// ataque = (atacante.getEquipo1().getAtaqueFisico()) * (1 + potencia +
		// atacante.getEquipo1().getAtaqueEspecial());

		// ataque = atacante.getEquipo1().getAtaqueFisico() * (1 +
		// atacante.getEquipo1().getAtaqueEspecial());

		// turno.mensajeAtacante(atacante, ataque);

		// float defensa = defensor.getEquipo1().getDefensaFisica() * (1 +
		// defensor.getEquipo1().getDefensaEspecial());
		// float vida = defensor.getEquipo1().getPuntosSalud() * (1 +
		// defensor.getEquipo1().getNivel());
		// turno.mensajeDefensor(defensor, vida);
		// vida = vida - (ataque - defensa) * logicaTipos(atacante.getEquipo1(),
		// defensor.getEquipo1());
		// turno.mensajeDefensor(defensor, vida);

		// if (vida <= 0) {
		// turno.mostrarGanador(atacante);
		// }

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

	public static int convertirTipo(Tipo elemento) {

		if (elemento == Tipo.NORMAL)
			return 0;

		if (elemento == Tipo.DENDRO)
			return 1;

		if (elemento == Tipo.PYRO)
			return 2;

		if (elemento == Tipo.CRYO)
			return 3;

		if (elemento == Tipo.HYDRO)
			return 4;

		if (elemento == Tipo.ANEMO)
			return 5;

		if (elemento == Tipo.ELECTRO)
			return 6;

		if (elemento == Tipo.SECTO)
			return 7;

		if (elemento == Tipo.GEO)
			return 8;

		return -1;
	}

	// Bono o reducción de daño por tipos de movimientos
	public static float logicaTipos(Movimiento atacante, Pokemon defensor) {

		int a = convertirTipo(atacante.getTipo());
		int d = convertirTipo(defensor.getTipo1());

		/*
		 * NORMAL=0
		 * DENDRO=1
		 * PYRO=2
		 * CRYO=3
		 * HYDRO=4
		 * ANEMO=5
		 * ELECTRO=6
		 * SECTO=7
		 * GEO=8
		 */

		float efectividad[][] = new float[9][9];

		// NORMAL
		efectividad[0][0] = 1f; // NORMAL
		efectividad[0][1] = 1f; // DENDRO
		efectividad[0][2] = 1f; // PYRO
		efectividad[0][3] = 1f; // CRYO
		efectividad[0][4] = 1f; // HYDRO
		efectividad[0][5] = 1f; // ANEMO
		efectividad[0][6] = 1f; // ELECTRO
		efectividad[0][7] = 1f; // SECTO
		efectividad[0][8] = 1f; // GEO

		// DENDRO
		efectividad[1][0] = 1f; // NORMAL
		efectividad[1][1] = 1f; // DENDRO
		efectividad[1][2] = 0.5f; // PYRO
		efectividad[1][3] = 1f; // CRYO
		efectividad[1][4] = 1.5f; // HYDRO
		efectividad[1][5] = 0.5f; // ANEMO
		efectividad[1][6] = 2f; // ELECTRO
		efectividad[1][7] = 0.5f; // SECTO
		efectividad[1][8] = 1f; // GEO

		// PYRO
		efectividad[2][0] = 1f; // NORMAL
		efectividad[2][1] = 2f; // DENDRO
		efectividad[2][2] = 1f; // PYRO
		efectividad[2][3] = 2f; // CRYO
		efectividad[2][4] = 1.5f; // HYDRO
		efectividad[2][5] = 1f; // ANEMO
		efectividad[2][6] = 1f; // ELECTRO
		efectividad[2][7] = 2f; // SECTO
		efectividad[2][8] = 1f; // GEO

		// CRYO
		efectividad[3][0] = 1f; // NORMAL
		efectividad[3][1] = 1f; // DENDRO
		efectividad[3][2] = 1.5f; // PYRO
		efectividad[3][3] = 1f; // CRYO
		efectividad[3][4] = 2f; // HYDRO
		efectividad[3][5] = 1f; // ANEMO
		efectividad[3][6] = 1.5f; // ELECTRO
		efectividad[3][7] = 2f; // SECTO
		efectividad[3][8] = 1f; // GEO

		// HYDRO
		efectividad[4][0] = 1f; // NORMAL
		efectividad[4][1] = 1.5f; // DENDRO
		efectividad[4][2] = 2f; // PYRO
		efectividad[4][3] = 0.5f; // CRYO
		efectividad[4][4] = 1f; // HYDRO
		efectividad[4][5] = 1f; // ANEMO
		efectividad[4][6] = 1.5f; // ELECTRO
		efectividad[4][7] = 1.5f; // SECTO
		efectividad[4][8] = 2f; // GEO

		// ANEMO
		efectividad[5][0] = 1f; // NORMAL
		efectividad[5][1] = 2f; // DENDRO
		efectividad[5][2] = 1f; // PYRO
		efectividad[5][3] = 1f; // CRYO
		efectividad[5][4] = 1f; // HYDRO
		efectividad[5][5] = 1f; // ANEMO
		efectividad[5][6] = 1f; // ELECTRO
		efectividad[5][7] = 0.5f; // SECTO
		efectividad[5][8] = 1f; // GEO

		// ELECTRO
		efectividad[6][0] = 1f; // NORMAL
		efectividad[6][1] = 0.5f; // DENDRO
		efectividad[6][2] = 1f; // PYRO
		efectividad[6][3] = 1.5f; // CRYO
		efectividad[6][4] = 1.5f; // HYDRO
		efectividad[6][5] = 1f; // ANEMO
		efectividad[6][6] = 1f; // ELECTRO
		efectividad[6][7] = 2f; // SECTO
		efectividad[6][8] = 1f; // GEO

		// SECTO
		efectividad[7][0] = 1f; // NORMAL
		efectividad[7][1] = 2f; // DENDRO
		efectividad[7][2] = 2f; // PYRO
		efectividad[7][3] = 2f; // CRYO
		efectividad[7][4] = 1.5f; // HYDRO
		efectividad[7][5] = 2f; // ANEMO
		efectividad[7][6] = 0.5f; // ELECTRO
		efectividad[7][7] = 1f; // SECTO
		efectividad[7][8] = 1f; // GEO

		// GEO
		efectividad[8][0] = 2f; // NORMAL
		efectividad[8][1] = 2f; // DENDRO
		efectividad[8][2] = 1f; // PYRO
		efectividad[8][3] = 2f; // CRYO
		efectividad[8][4] = 0.5f; // HYDRO
		efectividad[8][5] = 1f; // ANEMO
		efectividad[8][6] = 1f; // ELECTRO
		efectividad[8][7] = 1f; // SECTO
		efectividad[8][8] = 0.5f; // GEO

		return efectividad[a][d];
	}

}