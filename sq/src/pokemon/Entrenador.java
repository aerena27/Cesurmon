package pokemon;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import combate.Estado;
import combate.Tipo;

public class Entrenador {

	private String nombre;
	private int dinero;
	private List<Pokemon> equipo1;
//	private List<Pokemon> equipo2;
	private List<Pokemon> cajaPokemon;

	public Entrenador(String nombre, int dinero, Pokemon poke1, Pokemon poke2, Pokemon poke3, Pokemon poke4) {
		equipo1 = new LinkedList<>();
		//equipo2 = new LinkedList<>();
		cajaPokemon = new LinkedList<>();
		this.nombre = nombre;
		this.dinero = dinero;

		equipo1.add(poke1);
		equipo1.add(poke2);
		equipo1.add(poke3);
		equipo1.add(poke4);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public List<Pokemon> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Pokemon> equipo1) {
		this.equipo1 = equipo1;
	}

	public Pokemon sacarPokemon() {
		for (int i = 0; i < getEquipo1().size(); i++) {
			if (getEquipo1().get(i).getPuntosSaludCombate() > 0) {
				return getEquipo1().get(i);
			}
		}
		return null;
	}

	public Pokemon generarPokemon() {
		Random rando = new Random();
		int id = rando.nextInt(10) + 1;
		int ps = rando.nextInt(99) + 1;
		int atFi = rando.nextInt(99) + 1;
		int deFi = rando.nextInt(99) + 1;
		int atEs = rando.nextInt(99) + 1;
		int deEs = rando.nextInt(99) + 1;
		int vel = rando.nextInt(99) + 1;
		int nivel = rando.nextInt(10) + 1;
		Pokemon pokemon = new Pokemon(id, "test", ps, atFi, deFi, atEs, deEs, vel, nivel, 0, Estado.SIN_ESTADO,
				Tipo.CRYO, null, null, null, null);
		return pokemon;
	}

	public void capturar() {
		Random rando = new Random();
		Scanner sc = new Scanner(System.in);
		int eleccion = 1; // elección del menú
		int eleccionCaptura; // elección de capturar o huir
		int contadorTurnos = 0; // contador de turnos disponibles
		int contadorTurnos2 = 0; // condición de preguntar si seguir capturando
		int acierto; // probabilidad de captura

		while (eleccion == 1 || eleccion == 2) {

			Pokemon objetivo = generarPokemon();

			System.out.println("Pokemon: " + objetivo.getIdEspecie());

			System.out.println("1 (capturar), 2 (aleatorizar), 3 (salir)");
			eleccion = sc.nextInt();

			if (eleccion == 1) {
				while (contadorTurnos < 3) {
					contadorTurnos++;
					contadorTurnos2++;
					acierto = rando.nextInt(99);
					if (acierto == 0) {
						System.out.println("¡Captura completada!");
						cajaPokemon.add(objetivo);
						contadorTurnos = 3;
						contadorTurnos2 = 3;
					} else {
						System.out.println("¡Ha fallado!");
					}

					if (contadorTurnos2 < 3) { // Condición de seguir preguntando
						System.out.println("1 (seguir capturando), 2 (huir)");
						eleccionCaptura = sc.nextInt();
						if (eleccionCaptura == 2) {
							contadorTurnos = 3;
						}
					}

				}
				contadorTurnos = 0;
				contadorTurnos2 = 0;
			}

			if (eleccion == 2) {
				eleccion = 2;
			}
			if (eleccion == 3) {
				eleccion = 3;
			}

		}
		sc.close();
	}

}
