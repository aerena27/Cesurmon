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
import javafx.stage.Stage;

public class MenuCombateController implements Initializable {

    @FXML
    private Button btnHuir; // 

    @FXML
    private void volverMenuPrincipal(ActionEvent event) throws Exception { //
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuir.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void entrarMenuMovimientos(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
