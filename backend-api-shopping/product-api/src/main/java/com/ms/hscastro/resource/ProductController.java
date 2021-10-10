package com.ms.hscastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hscastro.dto.ProductDTO;
import com.ms.hscastro.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/products")
	public @ResponseBody ResponseEntity<ProductDTO> createUser(@RequestBody ProductDTO productDTO) {
		ProductDTO newUser = productService.saveProduct(productDTO);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/products")
	public @ResponseBody ResponseEntity<List<ProductDTO>> listAllProducts() {
		List<ProductDTO> lista = productService.listAllProduct();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/products/{id}")
	public @ResponseBody ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
		ProductDTO product = productService.findProductById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/products/{identifier}")
	public @ResponseBody ResponseEntity<ProductDTO> getProductByIdentifier(@PathVariable("identifier") String identifier) {
		ProductDTO product = productService.findProductByIdentifier(identifier);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/{productId}")
	public @ResponseBody ResponseEntity<ProductDTO> deleteUserByCpf(@PathVariable("productId") Long productId) {
		ProductDTO Product = productService.deleteProductById(productId);
		return ResponseEntity.ok(Product);
	}
}
