package com.ms.hscastro.dto;


import javax.validation.constraints.NotBlank;

import com.ms.hscastro.entities.Category;


public class CategoryDTO {

	@NotBlank
	private Long id;
	
	@NotBlank
	private String nome;
	
	public CategoryDTO() {
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
		
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}
	
}
