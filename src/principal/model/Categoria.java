package principal.model;

import java.io.Serializable;

public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 5064595664181620266L;
	
	private Integer id;
	private String nome;
	private String desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Categoria(Integer id, String nome, String desc) {
		super();
		this.id = id;
		this.nome = nome;
		this.desc = desc;
	}
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
