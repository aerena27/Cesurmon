package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import combate.Tipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class CesurmonController implements Initializable {

    /**
     * MENÚ PRINCIPAL
     */

    private Entrenador usuario;

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

    @FXML
    private TextField textoNombreSalvaje;

    @FXML
    private TextField textoCapturaLog;

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
        turnosCaptura++;

        if (capturaCompletada == true) {
            usuario.meterCaja(pokemonSalvaje);
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
        textoNombreSalvaje.setText("ID Pokemon: " + String.valueOf(pokemonSalvaje.getIdEspecie()));
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

    @FXML
    private Button btnHuirCombate; // combateVolverMenuPrincipal

    @FXML
    private void combateVolverMenuPrincipal(ActionEvent event) throws Exception { // btnHuirCombate
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuirCombate.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnMovimiento1; // usarMovimiento1

    @FXML
    private void usarMovimiento1(ActionEvent event) { // btnMovimiento1

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

    // INICIALIZAR
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuario = new Entrenador("Pepe", 9999, null, null, null, null);
    }

}
