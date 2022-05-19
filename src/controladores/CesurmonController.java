package controladores;

import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        txtPokemonUsuario.setText("N. Pokedex nuestro: " + pokeUsuario.getIdEspecie());
        txtPokemonRival.setText("N. Pokedex rival: " + pokeRival.getIdEspecie());
        txtVidaUsuario.setText("PS: " + pokeUsuario.getPuntosSalud() + "/"
                + pokeUsuario.getPuntosSaludCombate());
        txtVidaRival.setText("PS: " + pokeRival.getPuntosSalud() + "/"
                + pokeRival.getPuntosSaludCombate());
        txtResistenciaUsuario.setText("Estam.: " + pokeUsuario.getResistencia());
        txtResistenciaRival.setText("Estam.: " + pokeRival.getResistencia());
    }

    @FXML
    private void iniciarCombate() {
        pokeUsuario = usuario.sacarPokemon();
        pokeRival = cpu.sacarPokemon();
        setTextos();
        combate = new Combate(usuario, cpu);
    }

    @FXML
    private Button btnMovimiento1; // usarMovimiento1

    @FXML
    private void usarMovimiento1(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(0);
        moviUsuario.usarMovimiento(pokeUsuario, pokeRival);
        setTextos();
    }

    @FXML
    private Button btnMovimiento2; // usarMovimiento1

    @FXML
    private void usarMovimiento2(ActionEvent event) { // btnMovimiento1

    }

    @FXML
    private Button btnMovimiento3; // usarMovimiento1

    @FXML
    private void usarMovimiento3(ActionEvent event) { // btnMovimiento1

    }

    @FXML
    private Button btnMovimiento4; // usarMovimiento1

    @FXML
    private void usarMovimiento4(ActionEvent event) { // btnMovimiento1

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
        Pokemon poke1 = new Pokemon(1, "Pikachu1", Tipo.ELECTRO, placaje, null, null, null);
        Pokemon poke2 = new Pokemon(2, "Pikachu2", Tipo.ELECTRO, placaje, null, null, null);
        poke1.setMaxStats();
        usuario = new Entrenador("Pepe", 9999, poke1, poke1, poke1, poke1);
        cpu = new Entrenador("Luis", 9999, poke2, null, null, null);
    }

}
