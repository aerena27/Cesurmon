package pokemon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import combate.Estado;
import combate.Tipo;
import movimientos.Movimiento;

public class Pokemon {

	private int idPersonal;
	private int idEspecie;
	private String nombreEspecie;
	private String mote;
	private int puntosSalud;
	private int puntosSaludCombate;
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
	private int resistencia;
	private List<Movimiento> movimientos;
	private List<Movimiento> movimientosAprendidos;

	public Pokemon(int idEspecie, String nombreEspecie, Tipo tipo, Movimiento movimiento1, Movimiento movimiento2,
			Movimiento movimiento3, Movimiento movimiento4) {
		super();

		Random random = new Random();

		movimientos = new LinkedList<>();
		movimientosAprendidos = new LinkedList<>();

		this.idPersonal = random.nextInt(999) + 1;
		this.idEspecie = idEspecie;
		this.nombreEspecie = nombreEspecie;
		this.puntosSalud = random.nextInt(99) + 1;
		this.puntosSaludCombate = this.puntosSalud;
		this.ataqueFisico = random.nextInt(99) + 1;
		this.defensaFisica = random.nextInt(99) + 1;
		this.ataqueEspecial = random.nextInt(99) + 1;
		this.defensaEspecial = random.nextInt(99) + 1;
		this.velocidad = random.nextInt(99) + 1;
		this.nivel = 1;
		this.experiencia = 0;
		this.fertilidad = 5;
		this.estado = Estado.SIN_ESTADO;
		this.turnosParado = 0;
		this.tipo = tipo;
		this.resistencia = 10;
		movimientos.add(movimiento1);
		movimientos.add(movimiento2);
		movimientos.add(movimiento3);
		movimientos.add(movimiento4);

		movimientosAprendidos = new ArrayList<Movimiento>();

		anadirMovimientoAprendido(movimiento1);
		anadirMovimientoAprendido(movimiento2);
		anadirMovimientoAprendido(movimiento3);
		anadirMovimientoAprendido(movimiento4);

	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
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

	public int getPuntosSaludCombate() {
		return puntosSaludCombate;
	}

	public void setPuntosSaludCombate(int puntosSaludCombate) {
		this.puntosSaludCombate = puntosSaludCombate;
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

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public Movimiento getMovimiento(int i) {
		return movimientos.get(i);
	}

	public List<Movimiento> getMovimientosAprendidos() {
		return movimientosAprendidos;
	}

	public void anadirMovimientoAprendido(Movimiento movimiento) {
		if (movimiento != null && movimientosAprendidos.contains(movimiento) == false) {
			movimientosAprendidos.add(movimiento);
		}
	}

	public void descansar() {
		setResistencia(10);
	}

	public void setMaxStats() {
		setPuntosSaludCombate(999);
		setPuntosSalud(999);
		setAtaqueFisico(999);
		setDefensaFisica(999);
		setAtaqueEspecial(999);
		setDefensaEspecial(999);
		setVelocidad(999);
	}

	public void setMinStats() {
		setPuntosSaludCombate(1);
		setPuntosSalud(1);
		setAtaqueFisico(1);
		setDefensaFisica(1);
		setAtaqueEspecial(1);
		setDefensaEspecial(1);
		setVelocidad(1);
	}

}