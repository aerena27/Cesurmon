package controladores;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import combate.Combate;
import combate.Tipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import movimientos.Efectividad;
import movimientos.MovAtaqueEspecial;
import movimientos.MovAtaqueFisico;
import movimientos.Movimiento;
import movimientos.MovimientoAtaque;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class CesurmonController implements Initializable {

    /**
     * MENÚ PRINCIPAL
     */

    private Entrenador usuario;
    private Entrenador cpu;

    @FXML
    private Button btnMenuCombatir; // entrarMenuCombate

    @FXML
    private void entrarMenuCombate() throws Exception { // btnCombatir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCombate.fxml"));
        Stage window = (Stage) btnMenuCombatir.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnMenuCapturar; // entrarMenuCaptura

    @FXML
    private void entrarMenuCaptura() throws Exception { // btnCapturar
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCaptura1.fxml"));
        Stage window = (Stage) btnMenuCapturar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnHolaMundo; // sayHelloWorld

    @FXML
    private void sayHelloWorld(ActionEvent event) { // btnHolaMundo
        System.out.println("Hola mundo");
    }

    /**
     * MENÚ DE CAPTURAR
     */

    private Pokemon pokemonSalvaje;
    private int turnosCaptura = 0;
    private int totalCapturas = 0;
    private int totalIntentos = 0;

    @FXML
    private TextField textoNombreSalvaje;

    @FXML
    private TextField textoCapturaLog;

    @FXML
    private TextField textoCapturasTotal;

    @FXML
    private TextField textoIntentosTotal;

    @FXML
    private Button btnHuirCaptura; // volverMenuPrincipal

    @FXML
    private void capturaVolverMenuPrincipal(ActionEvent event) throws Exception { // btnHuir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuirCaptura.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnLanzarBall; // intentarCapturar

    @FXML
    private void intentarCapturar() { // btnLanzarBall
        Boolean capturaCompletada = usuario.intentarCapturar();
        totalIntentos++;
        textoIntentosTotal.setText("Intentos: " + totalIntentos);
        turnosCaptura++;
        if (capturaCompletada == false) {
            textoCapturasTotal.setText("Capturas: " + totalCapturas);
            if (turnosCaptura >= 3) {
                textoCapturaLog.setText("Se ha escapado...");
            } else {
                textoCapturaLog.setText("Has fallado...");
            }
        }
        if (capturaCompletada == true) {
            textoCapturaLog.setText("¡Pokémon atrapado!");
            usuario.meterCaja(pokemonSalvaje);
            totalCapturas++;
            aleatorizarSalvaje();
        } else if (turnosCaptura >= 3) {
            aleatorizarSalvaje();
        }
    }

    @FXML
    private Button btnAleatorizarSalvaje;

    @FXML
    private void aleatorizarSalvaje() {
        turnosCaptura = 0;
        pokemonSalvaje = usuario.generarPokemon();
        // TODO: Poner el texto con el nombre de la especie
        textoNombreSalvaje.setText("N. Pokedex: " + pokemonSalvaje.getIdEspecie());
        textoCapturasTotal.setText("Capturas: " + totalCapturas);
        textoIntentosTotal.setText("Intentos: " + totalIntentos);
    }

    @FXML
    TextField dialogoTexto;

    @FXML
    TextField textoNombreRival;

    @FXML
    private void mostrarNombreRival() {
    }

    /**
     * COMBATE
     */

    Pokemon pokeUsuario;
    Pokemon pokeRival;
    Movimiento moviUsuario;
    Movimiento moviRival;
    Combate combate;
    int variableVictorias = 0;

    @FXML
    private TextField txtPokemonUsuario;

    @FXML
    private TextField txtPokemonRival;

    @FXML
    private TextField txtVidaUsuario;

    @FXML
    private TextField txtVidaRival;

    @FXML
    private TextField txtAccionUsuario;

    @FXML
    private TextField txtAccionRival;

    @FXML
    private TextField txtResistenciaUsuario;

    @FXML
    private TextField txtResistenciaRival;

    @FXML
    private TextField txtVentaja1;

    @FXML
    private TextField txtVentaja2;

    @FXML
    private TextField txtVentaja3;

    @FXML
    private TextField txtVentaja4;

    @FXML
    private TextField txtTurnosCombate;

    @FXML
    private TextField txtContadorKO;

    @FXML
    private TextField txtContadorVictorias;

    @FXML
    private Button btnHuirCombate; // combateVolverMenuPrincipal

    @FXML
    private void combateVolverMenuPrincipal(ActionEvent event) throws Exception { // btnHuirCombate

        usuario.darDinero(cpu);

        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuirCombate.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnIniciarCombate;

    @FXML
    private void setTextos() {
        txtPokemonUsuario.setText(pokeUsuario.getNombreEspecie());
        txtPokemonRival.setText(pokeRival.getNombreEspecie());
        txtVidaUsuario.setText("PS: " + pokeUsuario.getPuntosSalud() + "/"
                + pokeUsuario.getPuntosSaludCombate());
        txtVidaRival.setText("PS: " + pokeRival.getPuntosSalud() + "/"
                + pokeRival.getPuntosSaludCombate());
        txtResistenciaUsuario.setText("Estam.: " + pokeUsuario.getResistencia());
        txtResistenciaRival.setText("Estam.: " + pokeRival.getResistencia());

        txtTurnosCombate.setText("Turno: " + combate.getNumeroTurno());
        txtContadorKO.setText("Contador actual: " + combate.getKoJugador() + " - " + combate.getKoRival());
        txtContadorVictorias.setText("Victorias: " + combate.getContadorVictorias());

        txtVentaja1.setText(pokeUsuario.getMovimiento(0).checkVentaja(pokeRival));
        txtVentaja2.setText(pokeUsuario.getMovimiento(1).checkVentaja(pokeRival));
        txtVentaja3.setText(pokeUsuario.getMovimiento(2).checkVentaja(pokeRival));
        txtVentaja4.setText(pokeUsuario.getMovimiento(3).checkVentaja(pokeRival));

        btnMovimiento1.setText(pokeUsuario.getMovimiento(0).getNombreHabilidad());
        btnMovimiento2.setText(pokeUsuario.getMovimiento(1).getNombreHabilidad());
        btnMovimiento3.setText(pokeUsuario.getMovimiento(2).getNombreHabilidad());
        btnMovimiento4.setText(pokeUsuario.getMovimiento(3).getNombreHabilidad());
    }

    @FXML
    private void setTextosAcciones() {
        txtAccionUsuario.setText(pokeUsuario.getMote() + " ha usado " + moviUsuario.getNombreHabilidad());
        txtAccionRival.setText(pokeRival.getMote() + " ha usado " + moviRival.getNombreHabilidad());
    }

    @FXML
    private void iniciarCombate() {
        pokeUsuario = usuario.sacarPokemon();
        pokeRival = cpu.sacarPokemon();
        combate = new Combate(usuario, cpu);
        setTextos();
    }

    @FXML
    private void continuarCombate() {
        pokeUsuario = usuario.sacarPokemon();
        pokeRival = cpu.sacarPokemon();
        setTextos();
    }

    @FXML
    private void escogerMovimientoRival() {
        Random random = new Random();
        int eleccion = random.nextInt(3);
        moviRival = pokeRival.getMovimiento(eleccion);
    }

    @FXML
    private Button btnMovimiento1;

    @FXML
    private void usarMovimiento1(ActionEvent event) {
        moviUsuario = pokeUsuario.getMovimiento(0);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnMovimiento2; // usarMovimiento1

    @FXML
    private void usarMovimiento2(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(1);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnMovimiento3; // usarMovimiento1

    @FXML
    private void usarMovimiento3(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(2);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnMovimiento4; // usarMovimiento1

    @FXML
    private void usarMovimiento4(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(3);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnDescansar;

    @FXML
    private void descansar() {

    }

    // INICIALIZAR
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MovAtaqueFisico placaje = new MovAtaqueFisico(Tipo.NORMAL, "Placaje", 1, 50);
        MovAtaqueEspecial ascuas = new MovAtaqueEspecial(Tipo.PYRO, "Ascuas", 1, 50);
        MovAtaqueFisico latigoCepa = new MovAtaqueFisico(Tipo.DENDRO, "Latigo cepa", 1, 50);
        MovAtaqueEspecial pistolaAgua = new MovAtaqueEspecial(Tipo.HYDRO, "Pistola agua", 1, 50);

        Pokemon poke1 = new Pokemon(1, "Pikachu1", Tipo.ELECTRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke2 = new Pokemon(2, "Blastoise1", Tipo.HYDRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke3 = new Pokemon(3, "Charizard1", Tipo.PYRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke4 = new Pokemon(4, "Venusaur1", Tipo.DENDRO, placaje, ascuas, latigoCepa, pistolaAgua);

        Pokemon poke5 = new Pokemon(5, "Pikachu2", Tipo.ELECTRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke6 = new Pokemon(6, "Blastoise2", Tipo.HYDRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke7 = new Pokemon(7, "Charizard2", Tipo.PYRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke8 = new Pokemon(8, "Venusaur2", Tipo.DENDRO, placaje, ascuas, latigoCepa, pistolaAgua);

        poke1.setMaxStats();
        poke2.setMaxStats();
        poke3.setMaxStats();
        poke4.setMaxStats();

        usuario = new Entrenador("Pepe", 9999, poke1, poke2, poke3, poke4);
        cpu = new Entrenador("Luis", 9999, poke5, poke6, poke7, poke8);
    }

}
