package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import principal.model.Usuarios;

public class UsuariosController {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfUser;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private PasswordField pfConfSenha;

    @FXML
    private Button btnCad;

    @FXML
    private TableView<Usuarios> tbl;

    @FXML
    private TableColumn<Usuarios, Number> tbcID;

    @FXML
    private TableColumn<Usuarios, String> tbcNome;

    @FXML
    private TableColumn<Usuarios, String> tbcUser;

    @FXML
    private Button btnExc;

    @FXML
    private Button btnCanc;

    @FXML
    void SelecionaUsuario(MouseEvent event) {

    }

    @FXML
    void btnCad(ActionEvent event) {

    }

    @FXML
    void btnCanc(ActionEvent event) {

    }

    @FXML
    void btnExc(ActionEvent event) {

    }

}
