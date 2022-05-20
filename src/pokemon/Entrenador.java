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
	private List<Pokemon> equipo2;
	private List<Pokemon> cajaPokemon;

	public Entrenador(String nombre, int dinero, Pokemon poke1, Pokemon poke2, Pokemon poke3, Pokemon poke4) {
		equipo1 = new LinkedList<>();
		equipo2 = new LinkedList<>();
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

	public Pokemon getPokemon(int i) {
		return equipo1.get(i);
	}

	public List<Pokemon> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Pokemon> equipo1) {
		this.equipo1 = equipo1;
	}

	/**
	 * Comprobar el primer Pokémon del equipo 1 que esté vivo para sacarlo en
	 * combate al debilitar el anterior
	 * 
	 * @return Pokémon que esté vivo
	 */
	public Pokemon sacarPokemon() {
		Pokemon pokemon;
		for (int i = 0; i < getEquipo1().size(); i++) {
			if (getEquipo1().get(i).getPuntosSaludCombate() > 0) {
				pokemon = getEquipo1().get(i);
				return pokemon;
			}
		}
		return null;
	}

	/**
	 * Añadir nuevo Pokémon a la caja
	 * 
	 * @param pokemon
	 */
	public void meterCaja(Pokemon pokemon) {
		cajaPokemon.add(pokemon);
	}

	/**
	 * Generar un Pokémon al azar para testear
	 * 
	 * @return Pokémon aleatorio
	 */
	public Pokemon generarPokemon() {
		Random rando = new Random();
		int id = rando.nextInt(150) + 1;
		Pokemon pokemon = new Pokemon(id, "test", Tipo.NORMAL, null, null, null, null);
		return pokemon;
	}

	/**
	 * Generar un equipo de Pokémon al azar para testear rival en combate
	 */
	public void generarEquipo() {
		// TODO: Aleatorizar equipo completo para el rival en combate
	}

	/**
	 * Método de captura extendido en el controlador de las vistas
	 * Controla la probabilidad de acierto en la captura
	 * 
	 * @return Pokémon generado
	 */
	public Boolean intentarCapturar() {
		Random rando = new Random();
		int acierto = rando.nextInt(2); // probabilidad de captura

		if (acierto == 0) {
			System.out.println(true);
			return true;
		}
		System.out.println(false);
		return false;
	}

	/**
	 * Comprobar si se dispone de dinero suficiente para comprar algo
	 * 
	 * @param cantidadNecesaria coste de lo que se quiere comprar
	 * @return Boolean de si hay disponible o no
	 */
	public Boolean checkDinero(int cantidadNecesaria) {
		if (getDinero() >= cantidadNecesaria) {
			return true;
		}
		return false;
	}

	/**
	 * Entregar dinero al perder un combate, asumiendo que el entrenador base es el
	 * perdedor
	 * 
	 * @param ganador Entrenador que recibirá nuestro dinero
	 */
	public void darDinero(Entrenador ganador) {
		int entregar = getDinero() / 3;
		setDinero(getDinero() - entregar);
		ganador.setDinero(ganador.getDinero() + entregar);
	}

	/**
	 * Método de entrenamiento que aumenta las estadísticas de un Pokémon
	 * 
	 * @param pokemon  Pokémon a mejorar
	 * @param eleccion Tipo de entrenamiento a ejecutar
	 */
	public void entrenar(Pokemon pokemon, int eleccion) {
		switch (eleccion) {
			case 1: // Entrenamiento pesado
				if (checkDinero(20 * pokemon.getNivel()) == true) {
					setDinero(getDinero() - 20 * pokemon.getNivel());
					pokemon.setDefensaFisica(pokemon.getDefensaFisica() + 5);
					pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);
					pokemon.setPuntosSalud(pokemon.getPuntosSalud() + 5);
					pokemon.setPuntosSaludCombate(pokemon.getPuntosSaludCombate() + 5);
				}
			case 2: // Entrenamiento furioso
				if (checkDinero(30 * pokemon.getNivel()) == true) {
					setDinero(getDinero() - 30 * pokemon.getNivel());
					pokemon.setAtaqueFisico(pokemon.getAtaqueFisico() + 5);
					pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);
					pokemon.setVelocidad(pokemon.getVelocidad() + 5);
				}
			case 3: // Entrenamiento funcional
				if (checkDinero(40 * pokemon.getNivel()) == true) {
					setDinero(getDinero() - 40 * pokemon.getNivel());
					pokemon.setVelocidad(pokemon.getVelocidad() + 5);
					pokemon.setAtaqueFisico(pokemon.getAtaqueFisico() + 5);
					pokemon.setDefensaFisica(pokemon.getDefensaFisica() + 5);
					pokemon.setPuntosSalud(pokemon.getPuntosSalud() + 5);
					pokemon.setPuntosSaludCombate(pokemon.getPuntosSaludCombate() + 5);
				}
			case 4: // Entrenamiento onírico
				if (checkDinero(40 * pokemon.getNivel()) == true) {
					setDinero(getDinero() - 40 * pokemon.getNivel());
					pokemon.setVelocidad(pokemon.getVelocidad() + 5);
					pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);
					pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);
					pokemon.setPuntosSalud(pokemon.getPuntosSalud() + 5);
					pokemon.setPuntosSaludCombate(pokemon.getPuntosSaludCombate() + 5);
				}
		}
	}

	/**
	 * Método de criar, genera un nuevo Pokémon a partir de otros 2, bajando la
	 * fertilidad de estos y obteniendo características mezcladas
	 * 
	 * @param padre
	 * @param madre
	 */
	public void ponerCriar(Pokemon padre, Pokemon madre) {
		Random rando = new Random();
		int tipoRando = rando.nextInt(1);

		Tipo tipo = (tipoRando == 1) ? padre.getTipo1() : madre.getTipo1();
		int ps = (padre.getPuntosSalud() >= madre.getPuntosSalud()) ? padre.getPuntosSalud() : madre.getPuntosSalud();
		int atFi = (padre.getAtaqueFisico() >= madre.getAtaqueFisico()) ? padre.getAtaqueFisico()
				: madre.getAtaqueFisico();
		int deFi = (padre.getDefensaFisica() >= madre.getDefensaFisica() ? padre.getDefensaFisica()
				: madre.getDefensaFisica());
		int atEs = (padre.getAtaqueEspecial() >= madre.getAtaqueEspecial()) ? padre.getAtaqueEspecial()
				: madre.getAtaqueEspecial();
		int deEs = (padre.getDefensaEspecial() >= madre.getDefensaEspecial()) ? padre.getDefensaEspecial()
				: padre.getDefensaEspecial();
		int vel = (padre.getVelocidad() >= padre.getVelocidad()) ? padre.getVelocidad() : madre.getVelocidad();

		// TODO: movimientos aleatorios y constructor
	}

}
