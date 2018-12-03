package principal.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public UsuariosDAO usuariosDao() {
		return new UsuariosJDBC();
	}

}
