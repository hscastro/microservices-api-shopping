package com.ms.hscastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hscastro.dto.ProductDTO;
import com.ms.hscastro.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ProductDTO> createUser(@RequestBody ProductDTO productDTO) {
		ProductDTO newUser = productService.saveProduct(productDTO);
		return ResponseEntity.ok(newUser);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ProductDTO>> listAllProducts() {
		List<ProductDTO> lista = productService.listAllProduct();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
		ProductDTO product = productService.findProductById(id);
		return ResponseEntity.ok(product);
	}

	@RequestMapping(value = "/products/{identifier}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ProductDTO> getProductByIdentifier(@PathVariable("identifier") String identifier) {
		ProductDTO product = productService.findProductByIdentifier(identifier);
		return ResponseEntity.ok(product);
	}
}
