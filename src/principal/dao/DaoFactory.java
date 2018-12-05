package principal.dao;

public interface DaoFactory {

	UsuariosDAO usuariosDao();
	
	CategoriaDAO categoriasDao();
	
	ClientesDAO clientesDao();
}
