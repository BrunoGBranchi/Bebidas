package principal.model;

import java.io.Serializable;

public class Produtos implements Serializable {
	
	private static final long serialVersionUID = -4671171859296374197L;
	private Integer id;
	private String fabricante;
	private Categoria categoria;
	private Float valuni;
	private Integer quantidade;
	private String fornecedor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Float getValuni() {
		return valuni;
	}
	public void setValuni(Float valuni) {
		this.valuni = valuni;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Produtos(Integer id, String fabricante, Categoria categoria, Float valuni, Integer quantidade,
			String fornecedor) {
		super();
		this.id = id;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.valuni = valuni;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
	}
	public Produtos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
