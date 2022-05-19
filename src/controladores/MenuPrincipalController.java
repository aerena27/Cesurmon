package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuPrincipalController implements Initializable {

    @FXML
    private Button btnHolaMundo; // %sayHelloWorld

    @FXML
    private TextField txtfield;

    @FXML
    private void sayHelloWorld(ActionEvent event) { // @btnHolaMundo
        System.out.println("Hola mundo");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
