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

    // MENÚ PRINCIPAL

    @FXML
    private Button btnMenuCombatir; // entrarMenuCombate

    @FXML
    private void entrarMenuCombate() throws Exception { // btnCombatir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCombatePrincipal.fxml"));
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

    }

    @FXML
    TextField dialogoTexto;

    @FXML
    private void mostrarMensaje() {

    }

    @FXML
    TextField textoNombreRival;

    @FXML
    private void mostrarNombreRival() {
    }

    // INICIALIZAR
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
