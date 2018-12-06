package principal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import principal.conexao.ConexaoUtil;
import principal.dao.AbstractFactory;
import principal.dao.UsuariosDAO;
import principal.model.Usuarios;

public class LoginController {
	
	@FXML
    private BorderPane bpPrincipal;
	
    @FXML
    private TextField tfUser;

    @FXML
    private PasswordField pfPass;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnCanc;
    
    UsuariosDAO usuariosDao = AbstractFactory.get().usuariosDao();
	
	Usuarios usuario;
    
    @FXML
    void btnCanc(ActionEvent event) {

    }

    @FXML
    void btnEntrar(ActionEvent event) {
    	
    	try {
    		
    		Connection con = ConexaoUtil.getConn();
    		String usua = tfUser.getText();
    		String sen = pfPass.getText();
    		String sql = "select usuario, senha from usuarios where usuario='"+usua+"'and senha='"+sen+"'";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		if (tfUser.getText().equals("") || (pfPass.getText().equals(""))) {
    			JOptionPane.showMessageDialog(null, "Campos não podem ser nulos.");
    		}
    		if (rs.next()) {
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(getClass().getResource("PrincipalForm.fxml"));
    			try {
    				BorderPane cursoView = (BorderPane) loader.load();
    				bpPrincipal.setCenter(cursoView);
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}

    		} else {
    			JOptionPane.showMessageDialog(null, "Usário ou senha incorretos!");
    			pfPass.setText("");
    		}
    		} catch(SQLException e){
    			e.printStackTrace();
    		}
    		}    	

    	
    }
