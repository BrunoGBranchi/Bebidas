package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private BorderPane bpPrincipal;

    @FXML
    private MenuItem mmiProdutos;

    @FXML
    private MenuItem mmiClientes;

    @FXML
    private MenuItem mmiCategorias;

    @FXML
    private MenuItem mmiUsuarios;

    @FXML
    void mmiCategoria(ActionEvent event) {

    }

    @FXML
    void mmiClientes(ActionEvent event) {

    }

    @FXML
    void mmiProdutos(ActionEvent event) {

    }

    @FXML
    void mmiUsuarios(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("UsuariosForm.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }
}
