package pokemon;

import java.util.ArrayList;

import combate.Estado;
import combate.Tipo;
import movimientos.Movimiento;

public class Pokemon {

	private int idEspecie;
	private String nombreEspecie;
	private String mote;
	private int puntosSalud;
	private int ataqueFisico;
	private int defensaFisica;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private int nivel;
	private int experiencia;
	private int fertilidad;
	private Estado estado;
	private int turnosParado;
	private Tipo tipo;
	private Movimiento[] movimientos;
	private ArrayList<Movimiento> movimientosAprendidos;

	public Pokemon(int idEspecie, String nombreEspecie, int puntosSalud, int ataqueFisico,
			int defensaFisica, int ataqueEspecial, int defensaEspecial, int velocidad, int nivel, int experiencia,
			Estado estado, Tipo tipo, Movimiento movimiento1, Movimiento movimiento2,
			Movimiento movimiento3, Movimiento movimiento4) {
		super();
		this.idEspecie = idEspecie;
		this.nombreEspecie = nombreEspecie;
		this.puntosSalud = puntosSalud;
		this.ataqueFisico = ataqueFisico;
		this.defensaFisica = defensaFisica;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.fertilidad = 5;
		this.estado = estado;
		this.turnosParado = 0;
		this.tipo = tipo;
		this.movimientos = new Movimiento[4];
		this.movimientos[0] = movimiento1;
		this.movimientos[1] = movimiento2;
		this.movimientos[2] = movimiento3;
		this.movimientos[3] = movimiento4;

		movimientosAprendidos = new ArrayList<Movimiento>();

		anadirMovimientoAprendido(movimiento1);
		anadirMovimientoAprendido(movimiento2);
		anadirMovimientoAprendido(movimiento3);
		anadirMovimientoAprendido(movimiento4);

	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombreEspecie() {
		return nombreEspecie;
	}

	public void setNombreEspecie(String nombreEspecie) {
		this.nombreEspecie = nombreEspecie;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public int getPuntosSalud() {
		return puntosSalud;
	}

	public void setPuntosSalud(int puntosSalud) {
		this.puntosSalud = puntosSalud;
	}

	public int getAtaqueFisico() {
		return ataqueFisico;
	}

	public void setAtaqueFisico(int ataqueFisico) {
		this.ataqueFisico = ataqueFisico;
	}

	public int getDefensaFisica() {
		return defensaFisica;
	}

	public void setDefensaFisica(int defensaFisica) {
		this.defensaFisica = defensaFisica;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getFertilidad() {
		return fertilidad;
	}

	public void setFertilidad(int fertilidad) {
		this.fertilidad = fertilidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getTurnosParado() {
		return turnosParado;
	}

	public void setTurnosParado(int turnosParado) {
		this.turnosParado = turnosParado;
	}

	public Tipo getTipo1() {
		return tipo;
	}

	public void setTipo1(Tipo tipo) {
		this.tipo = tipo;
	}

	public Movimiento getMovimientos(int i) {
		return movimientos[i];
	}

	public void setMovimientos(Movimiento[] movimientos) {
		this.movimientos = movimientos;
	}

	public ArrayList<Movimiento> getMovimientosAprendidos() {
		return movimientosAprendidos;
	}

	public void setMovimientosAprendidos(ArrayList<Movimiento> movimientosAprendidos) {
		this.movimientosAprendidos = movimientosAprendidos;
	}

	public void anadirMovimientoAprendido(Movimiento movimiento) {
		if (movimiento != null && movimientosAprendidos.contains(movimiento) == false) {
			movimientosAprendidos.add(movimiento);
		}
	}
}