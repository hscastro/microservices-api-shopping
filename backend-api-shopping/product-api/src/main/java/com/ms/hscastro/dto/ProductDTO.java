package com.ms.hscastro.dto;


import com.ms.hscastro.entities.Product;


public class ProductDTO {

	private Long id;
	private String nome;
	private float preco;
	private String descricao;
	private String identifier;
	private CategoryDTO categoryDTO;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public static ProductDTO convertToDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setDescricao(product.getDescricao());
		productDTO.setIdentifier(product.getIdentifier());
		
		if(product.getCategory() != null) {
			productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));			
		}
		return productDTO;
	}
	
}
