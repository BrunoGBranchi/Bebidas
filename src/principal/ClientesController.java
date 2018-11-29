package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import principal.model.Clientes;

public class ClientesController {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfTelefone;

    @FXML
    private Button btnCad;

    @FXML
    private Button btnExc;

    @FXML
    private Button btnCanc;

    @FXML
    private TableView<Clientes> tblClientes;

    @FXML
    private TableColumn<Clientes, Number> tbcID;

    @FXML
    private TableColumn<Clientes, String> tbcNome;

    @FXML
    private TableColumn<Clientes, String> tbcCnpj;

    @FXML
    private TableColumn<Clientes, String> tbcEmail;

    @FXML
    private TableColumn<Clientes, String> tbcEndereco;

    @FXML
    private TableColumn<Clientes, String> tbcTelefone;

    @FXML
    void btnCad(ActionEvent event) {

    }

    @FXML
    void btnCanc(ActionEvent event) {

    }

    @FXML
    void btnExc(ActionEvent event) {

    }

    @FXML
    void selecionaClientes(MouseEvent event) {

    }

}
