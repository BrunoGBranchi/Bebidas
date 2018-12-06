package principal;

import java.io.IOException;

import principal.dao.AbstractFactory;
import principal.dao.UsuariosDAO;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    
    private boolean editando;
    
    private UsuariosDAO usuariosDao = AbstractFactory.get().usuariosDao();
    
    private Usuarios usuario;
    
    @FXML
	public void initialize() {
		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcUser.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		novoUsuario();
	}
    
    @FXML
    void SelecionaUsuario(MouseEvent event) {
    	if (tbl.getSelectionModel().getSelectedItem() != null) {
			usuario = tbl.getSelectionModel().getSelectedItem();
			populaTela(usuario);
			editando = true;			
		}

    }

    @FXML
    void btnCad(ActionEvent event) {
    	populaUsuario();
		
		if (editando) {
			usuariosDao.alterar(usuario);
			
		} else {
			usuariosDao.inserir(usuario);
		}
		novoUsuario();
		tbl.refresh();
    }

    @FXML
    void btnCanc(ActionEvent event) {
    	Stage stage = new Stage();  
        try{
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalForm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Programa");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) btnCanc.getScene().getWindow();
            stage.close(); //fecha a pagina atual antes de sair
        }
    }

    @FXML
    void btnExc(ActionEvent event) {
    	usuariosDao.excluir(usuario);
    	novoUsuario();
    }
    
    @FXML
    public void populaUsuario() {
		usuario.setNome(tfNome.getText());
		usuario.setUsuario(tfUser.getText());
		usuario.setSenha(pfSenha.getText());
    }
    
    public void populaTela(Usuarios usuario) {
		tfNome.setText(usuario.getNome());
		tfUser.setText(usuario.getUsuario());
		pfSenha.setText(usuario.getSenha());
		pfConfSenha.setText(usuario.getSenha());
	}
        
    void novoUsuario() {
    	tfUser.clear();
		tfNome.clear();
		pfSenha.clear();
		pfConfSenha.clear();
		usuario = new Usuarios();
		editando = false;
		tbl.setItems(FXCollections.observableArrayList(usuariosDao.listar()));
    }
}
