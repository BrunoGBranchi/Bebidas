package principal;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import principal.dao.AbstractFactory;
import principal.dao.CategoriaDAO;
import principal.dao.ProdutosDAO;
import principal.model.Categoria;
import principal.model.Produtos;

public class ProdutosController {

    @FXML
    private TextField tfProduto;

    @FXML
    private TextField tfFabricante;

    @FXML
    private ComboBox<Categoria> cbxCategoria;

    @FXML
    private TextField tfValUni;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfFornecedor;

    @FXML
    private Button btnCad;

    @FXML
    private Button btnCanc;

    @FXML
    private Button btnExc;

    @FXML
    private TableView<Produtos> tblProdutos;

    @FXML
    private TableColumn<Produtos, Number> tbcID;

    @FXML
    private TableColumn<Produtos, String> tbcFabricante;

    @FXML
    private TableColumn<Categoria, Number> tbcCategoria;

    @FXML
    private TableColumn<Produtos, Number> tbcValUni;

    @FXML
    private TableColumn<Produtos, Number> tbcQuantidade;
    
    @FXML
    private TableColumn<Produtos, String> tbcProduto;

    @FXML
    private TableColumn<Produtos, String> tbcFornecedor;
    
    private boolean editando;
    
    private ProdutosDAO produtosDao = AbstractFactory.get().produtosDao();
    
    private CategoriaDAO categoriaDao = AbstractFactory.get().categoriasDao();
    
    private Produtos produto;
    
    @FXML
	public void initialize() {
		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		tbcFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		tbcFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
		tbcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tbcValUni.setCellValueFactory(new PropertyValueFactory<>("valuni"));
		tbcProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
	
		novoproduto();
		populaCombo();
	}
    
    private void populaCombo(){
		cbxCategoria.getItems().clear();
		for(Categoria veiculo: categoriaDao.listar()){
			cbxCategoria.getItems().add(veiculo);
		}
	}
    
    @FXML
    void SelecionaProduto(MouseEvent event) {
    	if (tblProdutos.getSelectionModel().getSelectedItem() != null) {
			produto = tblProdutos.getSelectionModel().getSelectedItem();
			populaTela(produto);
			editando = true;			
		}
    }

    @FXML
    void btnCad(ActionEvent event) {
    	populaproduto();
		
		if (editando) {
			produtosDao.alterar(produto);
			
		} else {
			produtosDao.inserir(produto);
		}
		novoproduto();
		tblProdutos.refresh();

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
    	produtosDao.excluir(produto);
    	novoproduto();
    }
    
    @FXML
    public void populaproduto() {
		produto.setProduto(tfProduto.getText());
		produto.setCategoria(cbxCategoria.getSelectionModel().getSelectedItem());
		produto.setFabricante(tfFabricante.getText());
		produto.setFornecedor(tfFornecedor.getText());
		produto.setQuantidade(Integer.valueOf(tfQuantidade.getText()));
		produto.setValuni(Float.valueOf(tfValUni.getText()));
    }
    
    public void populaTela(Produtos produto) {
		tfProduto.setText(produto.getProduto());
		tfFabricante.setText(produto.getFabricante());
		tfFornecedor.setText(produto.getFornecedor());
		tfQuantidade.setText(produto.getValuni().toString());
		tfValUni.setText(produto.getValuni().toString());
		cbxCategoria.getSelectionModel().select(produto.getCategoria());
		
	}
        
    void novoproduto() {
    	tfProduto.clear();
		tfFabricante.clear();
		tfFornecedor.clear();
		tfQuantidade.clear();
		tfValUni.clear();
		cbxCategoria.getSelectionModel().clearSelection();
		produto = new Produtos();
		editando = false;
		tblProdutos.setItems(FXCollections.observableArrayList(produtosDao.listar()));
    }

}
