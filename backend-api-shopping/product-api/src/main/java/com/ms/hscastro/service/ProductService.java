package com.ms.hscastro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hscastro.dto.ProductDTO;
import com.ms.hscastro.entities.Product;
import com.ms.hscastro.repositories.ProductRepository;

@Service @Transactional(readOnly = false)
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public ProductDTO saveProduct(ProductDTO productDTO) {
		ProductDTO newProductDTO = ProductDTO.convertToUser(
				productRepository.save(Product.convertToDTO(productDTO)));
		return newProductDTO;
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> listAllProduct() {
		List<Product> lista = productRepository.findAll(); 
		
		return lista
				.stream().map(ProductDTO::convertToUser)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ProductDTO.convertToUser(product.get());
		}		
		return null;
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findProductByIdentifier(String identifier) {
		Optional<Product> product = productRepository.findByIdentifier(identifier);
		if(product.isPresent()) {
			return ProductDTO.convertToUser(product.get());
		}		
		return null;		
	}

}
