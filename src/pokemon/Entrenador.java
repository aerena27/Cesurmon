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

	public void meterCaja(Pokemon pokemon) {
		cajaPokemon.add(pokemon);
	}

	public Pokemon generarPokemon() {
		Random rando = new Random();
		int id = rando.nextInt(10) + 1;
		Pokemon pokemon = new Pokemon(id, "test", Tipo.NORMAL, null, null, null, null);
		return pokemon;
	}

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

	public Boolean checkDinero(int cantidadNecesaria) {
		if (getDinero() >= cantidadNecesaria) {
			return true;
		}
		return false;
	}

	public void darDinero(Entrenador ganador) {
		int entregar = getDinero() / 3;
		setDinero(getDinero() - entregar);
		ganador.setDinero(ganador.getDinero() + entregar);
	}

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
