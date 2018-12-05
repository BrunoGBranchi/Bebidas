package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Categoria;

public class CategoriaJDBC implements CategoriaDAO {

	@Override
	public void inserir(Categoria dado) {
		try {
			String sql = "insert into categoria (nome, descr) values (?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getDesc());
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
	public void alterar(Categoria dado) {
		try {
			String sql = "update categoria set nome = ?, descr = ?" 
						+ " where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getDesc());
			statement.setInt(3, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Categoria dado) {
		try {
			String sql = "delete from categoria where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Categoria> listar() {

		List<Categoria> cate = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from categoria");
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
				categoria.setDesc(rs.getString("descr"));
				cate.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cate;

	}

}
