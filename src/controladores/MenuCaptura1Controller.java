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

public class MenuCaptura1Controller implements Initializable {

    @FXML
    private Button btnHuir; // volverMenuPrincipal

    @FXML
    private void volverMenuPrincipal(ActionEvent event) throws Exception { // btnHuir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuir.getScene().getWindow();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
