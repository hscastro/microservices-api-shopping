package com.ms.hscastro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hscastro.dto.ProductDTO;
import com.ms.hscastro.entities.Product;
import com.ms.hscastro.exceptions.CategoryNotFoundException;
import com.ms.hscastro.exceptions.ProductNotFoundException;
import com.ms.hscastro.repositories.CategoryRepository;
import com.ms.hscastro.repositories.ProductRepository;

@Service @Transactional(readOnly = false)
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public ProductDTO saveProduct(ProductDTO productDTO) {
		boolean existsCategory = categoryRepository
				.existsById(productDTO.getCategoryDTO().getId());
		if(!existsCategory) {
		   throw new CategoryNotFoundException();
		}
		ProductDTO newProductDTO = ProductDTO.convertToDTO(
				productRepository.save(Product.convertToProduct(productDTO)));
		return newProductDTO;
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> listAllProduct() {
		List<Product> lista = productRepository.findAll(); 
		
		return lista
				.stream().map(ProductDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> listProductByCategoryId(Long categoryId) {
		List<Product> lista = productRepository.getProductByCategoryId(categoryId);
		
		return lista
				.stream().map(ProductDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ProductDTO.convertToDTO(product.get());
		}		
		throw new ProductNotFoundException();
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findProductByIdentifier(String identifier) {
		Product product = productRepository.findByProductIdentifier(identifier);
		if(product != null) {
			return ProductDTO.convertToDTO(product);
		}		
		throw new ProductNotFoundException();		
	}
	
	public ProductDTO deleteProduct(Long idProduct) {
		Optional<Product> product = productRepository.findById(idProduct);
		
		if(product.isPresent()) {
			productRepository.delete(product.get());
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO deleteProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
			return ProductDTO.convertToDTO(product.get());
		}		
		throw new ProductNotFoundException();
	}

}
