package principal.model;

import java.io.Serializable;

public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 5771412417024383180L;
	
	private Integer id;
	private String nome;
	private String cnpj;
	private String email;
	private String endereco;
	private String telefone;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Clientes(Integer id, String nome, String cnpj, String email, String endereco, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
