package pokemon;

public class Entrenador {
	
	private String nombre;
	private int dinero;
	private Pokemon equipo1;
	private Pokemon equipo2;
	private Pokemon cajaPokemon;
	
	
	public Entrenador(String nombre, int dinero, Pokemon equipo1, Pokemon equipo2, Pokemon cajaPokemon) {
		super();
		this.nombre = nombre;
		this.dinero = dinero;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.cajaPokemon = cajaPokemon;
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
	public Pokemon getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Pokemon equipo1) {
		this.equipo1 = equipo1;
	}
	public Pokemon getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Pokemon equipo2) {
		this.equipo2 = equipo2;
	}
	public Pokemon getCajaPokemon() {
		return cajaPokemon;
	}
	public void setCajaPokemon(Pokemon cajaPokemon) {
		this.cajaPokemon = cajaPokemon;
	}

}
