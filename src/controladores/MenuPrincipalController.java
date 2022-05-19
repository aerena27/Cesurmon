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

public class MenuPrincipalController implements Initializable {

    @FXML
    private TextField txtfield;

    @FXML
    private Button btnCombatir; // entrarMenuCombate

    @FXML
    private void entrarMenuCombate() throws Exception { // btnCombatir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCombatePrincipal.fxml"));
        Stage window = (Stage) btnCombatir.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnCapturar; // entrarMenuCaptura

    @FXML
    private void entrarMenuCaptura() throws Exception { // btnCapturar
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCaptura1.fxml"));
        Stage window = (Stage) btnCapturar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnHolaMundo; // sayHelloWorld

    @FXML
    private void sayHelloWorld(ActionEvent event) { // btnHolaMundo
        System.out.println("Hola mundo");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pokemon pikachu = new Pokemon(20, "Pikachu", Tipo.ELECTRO, null, null, null, null);
        pikachu.setMaxStats();
        Entrenador paco = new Entrenador("Paco", 99999, null, null, null, null);
    }

}
