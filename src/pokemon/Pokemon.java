package pokemon;

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
	private Tipo tipo1;
	private Tipo tipo2;


	public Pokemon(int idEspecie, String nombreEspecie, String mote, int puntosSalud, int ataqueFisico,
			int defensaFisica, int ataqueEspecial, int defensaEspecial, int velocidad, int nivel, int experiencia,
			int fertilidad, Estado estado, Tipo tipo1, Tipo tipo2) {
		super();
		this.idEspecie = idEspecie;
		this.nombreEspecie = nombreEspecie;
		this.mote = mote;
		this.puntosSalud = puntosSalud;
		this.ataqueFisico = ataqueFisico;
		this.defensaFisica = defensaFisica;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.fertilidad = fertilidad;
		this.estado = estado;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
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
	public Tipo getTipo1() {
		return tipo1;
	}
	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}
	public Tipo getTipo2() {
		return tipo2;
	}
	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
	}
	
}