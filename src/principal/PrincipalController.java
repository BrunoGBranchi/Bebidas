package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
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
    	Stage stage = new Stage();  
        try{
            Parent root = FXMLLoader.load(getClass().getResource("UsuariosForm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gerenciador de Frotas - V1.1 Alpha");
            stage.show();
            stage.setMaximized(true);
        }catch(IOException e){
            e.printStackTrace();
        
    }

    }
}
