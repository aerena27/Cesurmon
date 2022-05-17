package pokemon;

import java.util.LinkedList;
import java.util.List;

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

	public List<Pokemon> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Pokemon> equipo1) {
		this.equipo1 = equipo1;
	}

	public Pokemon sacarPokemon() {
		for (int i = 0; i < getEquipo1().size(); i++) {
			if (getEquipo1().get(i).getPuntosSaludCombate() <= 0) {
				return getEquipo1().get(i);
			}
		}
		return null;
	}

}
