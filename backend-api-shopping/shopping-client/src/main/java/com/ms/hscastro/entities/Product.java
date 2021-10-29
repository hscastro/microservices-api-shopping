package com.ms.hscastro.entities;


import com.ms.hscastro.dto.ProductDTO;


public class Product {

	private Long id;
	
	private String nome;
	
	private Float preco;
	
	private String descricao;
	
	private String productIdentifier;
	
	private Category category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

    public Product(Long id, String nome, Float preco, String descricao, String productIdentifier, Category category) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.productIdentifier = productIdentifier;
		this.category = category;
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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static Product convertToProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco() );
		product.setDescricao(productDTO.getDescricao());
		product.setProductIdentifier(productDTO.getIdentifier());
		
		if(productDTO.getCategoryDTO() != null) {
			product.setCategory(Category.convert(productDTO.getCategoryDTO()));
		}
		return product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productIdentifier == null) ? 0 : productIdentifier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productIdentifier == null) {
			if (other.productIdentifier != null)
				return false;
		} else if (!productIdentifier.equals(other.productIdentifier))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
				
}
