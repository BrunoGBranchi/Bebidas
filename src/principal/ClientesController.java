package principal;

import java.io.IOException;

import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import principal.dao.AbstractFactory;
import principal.dao.ClientesDAO;
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
    
    private boolean editando;
    
    private ClientesDAO clientesDao = AbstractFactory.get().clientesDao();
    
    private Clientes cliente;

    @FXML
	public void initialize() {
		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tbcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		novocliente();
	}
    		
    @FXML
    void btnCad(ActionEvent event) {
    	populacliente();
		
		if (editando) {
			clientesDao.alterar(cliente);
			
		} else {
			clientesDao.inserir(cliente);
		}
		novocliente();
		tblClientes.refresh();
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
    	clientesDao.excluir(cliente);
    	novocliente();
    }

    @FXML
    void selecionaClientes(MouseEvent event) {
    	if (tblClientes.getSelectionModel().getSelectedItem() != null) {
			cliente = tblClientes.getSelectionModel().getSelectedItem();
			populaTela(cliente);
			editando = true;			
		}
    }
    
    @FXML
    public void populacliente() {
		cliente.setNome(tfNome.getText());
		cliente.setCnpj(tfCnpj.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setEndereco(tfEndereco.getText());
		cliente.setTelefone(tfTelefone.getText());
    }
    
    public void populaTela(Clientes cliente) {
		tfNome.setText(cliente.getNome());
		tfCnpj.setText(cliente.getCnpj());
		tfEmail.setText(cliente.getEmail());
		tfEndereco.setText(cliente.getEndereco());
		tfTelefone.setText(cliente.getTelefone());
		
	}
        
    void novocliente() {
    	tfCnpj.clear();
		tfNome.clear();
		tfEmail.clear();
		tfEndereco.clear();
		tfTelefone.clear();
		cliente = new Clientes();
		editando = false;
		tblClientes.setItems(FXCollections.observableArrayList(clientesDao.listar()));
    }
}
