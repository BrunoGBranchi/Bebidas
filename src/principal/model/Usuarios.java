package principal.model;

import java.io.Serializable;

public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 4099357629213759818L;
	
	private Integer id;
	private String nome;
	private String usuario;
	private String senha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuarios(Integer id, String nome, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
