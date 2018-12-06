package principal;

import java.io.IOException;

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
import principal.dao.CategoriaDAO;
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
    
    private boolean editando;
    
    private CategoriaDAO categoriasDao = AbstractFactory.get().categoriasDao();
    
    private Categoria categoria;
    
    @FXML
	public void initialize() {
		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
		novocategoria();
	}
    
    @FXML
    void btnAdd(ActionEvent event) {
    	populacategoria();
		
		if (editando) {
			categoriasDao.alterar(categoria);
			
		} else {
			categoriasDao.inserir(categoria);
		}
		novocategoria();
		tbcCategoria.refresh();

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
            stage = (Stage) BtnCanc.getScene().getWindow();
            stage.close(); //fecha a pagina atual antes de sair
        }

    }

    @FXML
    void btnExc(ActionEvent event) {
    	categoriasDao.excluir(categoria);
    	novocategoria();
    }
    
    @FXML
    void selecionaCategoria(MouseEvent event) {
    	if (tbcCategoria.getSelectionModel().getSelectedItem() != null) {
			categoria = tbcCategoria.getSelectionModel().getSelectedItem();
			populaTela(categoria);
			editando = true;			
		}
    }
    
    @FXML
    public void populacategoria() {
		categoria.setNome(tfNome.getText());
		categoria.setDesc(tfDesc.getText());
    }
    
    public void populaTela(Categoria categoria) {
		tfNome.setText(categoria.getNome());
		tfDesc.setText(categoria.getDesc());
	}
        
    void novocategoria() {
    	tfDesc.clear();
		tfNome.clear();
		categoria = new Categoria();
		editando = false;
		tbcCategoria.setItems(FXCollections.observableArrayList(categoriasDao.listar()));
    }

}
