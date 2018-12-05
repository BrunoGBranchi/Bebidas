package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Clientes;

public class ClientesJDBC implements ClientesDAO {

	@Override
	public void inserir(Clientes dado) {
		try {
			String sql = "insert into cliente (nome, cnpj, email, endereco, telefone) values (?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getCnpj());
			statement.setString(3, dado.getEmail());
			statement.setString(4, dado.getEndereco());
			statement.setString(5, dado.getTelefone());
			statement.executeUpdate();
			
			// Popular o objeto com o código gerado.
			// Somente nos caso de campo auto-incremento
			//ResultSet rs = statement.getGeneratedKeys();
			//rs.next();
			//dado.setCodigo(rs.getInt(1));
			//---->
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Clientes dado) {
		try {
			String sql = "update cliente set nome = ?, cnpj = ?, email = ?, endereco = ?, telefone = ?" 
						+ " where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getCnpj());
			statement.setString(3, dado.getEmail());
			statement.setString(4, dado.getEndereco());
			statement.setString(5, dado.getTelefone());
			statement.setInt(6, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Clientes dado) {
		try {
			String sql = "delete from Cliente where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Clientes> listar() {

		List<Clientes> client = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from cliente");
			while (rs.next()) {
				Clientes cliente = new Clientes();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
				client.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

}
