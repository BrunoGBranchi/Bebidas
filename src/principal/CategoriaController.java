package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import principal.model.Categoria;

public class CategoriaController {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDesc;

    @FXML
    private TableView<Categoria> tbcCategoria;

    @FXML
    private TableColumn<Categoria, Number> tbcID;

    @FXML
    private TableColumn<Categoria, String> tbcNome;

    @FXML
    private TableColumn<Categoria, String> tbcDesc;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnExc;

    @FXML
    private Button BtnCanc;
    
    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnCanc(ActionEvent event) {

    }

    @FXML
    void btnExc(ActionEvent event) {

    }
    
    @FXML
    void selecionaCategoria(MouseEvent event) {

    }

}
