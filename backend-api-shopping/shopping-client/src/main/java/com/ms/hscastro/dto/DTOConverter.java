package com.ms.hscastro.dto;

import com.ms.hscastro.entities.Category;
import com.ms.hscastro.entities.Product;


public class DTOConverter {
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}
	
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		
		if(product.getCategory() != null) {
			productDTO.setCategoryDTO(
					CategoryDTO.convert(product.getCategory())
			);
		}
		
		return productDTO;
	}
	

}
