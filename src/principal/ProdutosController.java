package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import principal.model.Categoria;
import principal.model.Produtos;

public class ProdutosController {

    @FXML
    private TextField tfProduto;

    @FXML
    private TextField tfFabricante;

    @FXML
    private ComboBox<?> cbxCategoria;

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
    private Button btnRelatorio;

    @FXML
    private TableView<Produtos> tblProdutos;

    @FXML
    private TableColumn<Produtos, Number> tbcID;

    @FXML
    private TableColumn<Produtos, String> tbcFabricante;

    @FXML
    private TableColumn<Categoria, String> tbcCategoria;

    @FXML
    private TableColumn<Produtos, Number> tbcValUni;

    @FXML
    private TableColumn<Produtos, Number> tbcQuantidade;

    @FXML
    private TableColumn<Produtos, String> tbcFornecedor;

    @FXML
    void SelecionaProduto(MouseEvent event) {

    }

    @FXML
    void btnCad(ActionEvent event) {

    }

    @FXML
    void btnCanc(ActionEvent event) {

    }

    @FXML
    void btnRelatorio(ActionEvent event) {

    }

}
