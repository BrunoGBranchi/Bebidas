package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Categoria;
import principal.model.Produtos;

public class ProdutosJDBC implements ProdutosDAO{
	
	@Override
	public void inserir(Produtos dado) {
		try {
			String sql = "insert into produto (produto, fabricante, fornecedor, valuni, quantidade, id_categoria) values (?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getProduto());
			statement.setString(2, dado.getFabricante());
			statement.setString(3, dado.getFornecedor());
			statement.setFloat(4, dado.getValuni());
			statement.setInt(5, dado.getQuantidade());
			statement.setString(6, dado.getCategoria().getId().toString());
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
	public void alterar(Produtos dado) {
		try {
			String sql = "update produto set produto = ?, fabricante = ?, fornecedor = ?, valuni = ?, quantidade = ?, id_categoria = ?" 
						+ " where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getProduto());
			statement.setString(2, dado.getFabricante());
			statement.setString(3, dado.getFornecedor());
			statement.setFloat(4, dado.getValuni());
			statement.setInt(5, dado.getQuantidade());
			statement.setString(6, dado.getCategoria().getId().toString());			
			statement.setInt(7, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Produtos dado) {
		try {
			String sql = "delete from Produto where id = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Produtos> listar() {

		List<Produtos> prod = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from produto where quantidade > 0");
			while (rs.next()) {
				Produtos produto = new Produtos();
				produto.setId(rs.getInt("id"));
				produto.setProduto(rs.getString("produto"));
				produto.setFornecedor(rs.getString("fornecedor"));
				produto.setFabricante(rs.getString("fabricante"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValuni(rs.getFloat("valuni"));
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				produto.setCategoria(categoria);
				prod.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

}
