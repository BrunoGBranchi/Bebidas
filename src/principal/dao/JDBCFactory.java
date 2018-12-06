package principal.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public UsuariosDAO usuariosDao() {
		return new UsuariosJDBC();
	}

	@Override
	public CategoriaDAO categoriasDao() {
		return new CategoriaJDBC();
	}

	@Override
	public ClientesDAO clientesDao() {
		return new ClientesJDBC();
	}
	
	@Override
	public ProdutosDAO produtosDao() {
		return new ProdutosJDBC();
	}
	
}
