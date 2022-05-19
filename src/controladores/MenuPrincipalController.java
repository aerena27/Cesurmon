package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Button btnHolaMundo; // sayHelloWorld

    @FXML
    private void sayHelloWorld(ActionEvent event) { // btnHolaMundo
        System.out.println("Hola mundo");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
