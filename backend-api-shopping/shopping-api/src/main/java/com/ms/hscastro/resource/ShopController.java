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

import com.ms.hscastro.dto.ShopDTO;
import com.ms.hscastro.service.ShopService;

@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	
	@PostMapping("/shops")
	public @ResponseBody ResponseEntity<ShopDTO> createUser(@RequestBody ShopDTO shopDTO) {
		ShopDTO newShop = shopService.saveShop(shopDTO);
		return ResponseEntity.ok(newShop);
	}

	@GetMapping("/shops")
	public @ResponseBody ResponseEntity<List<ShopDTO>> listAllProducts() {
		List<ShopDTO> lista = shopService.listAllShops();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/shops/{id}")
	public @ResponseBody ResponseEntity<ShopDTO> getShopById(@PathVariable("id") Long id) {
		ShopDTO shop = shopService.findShopById(id);
		return ResponseEntity.ok(shop);
	}

	@GetMapping("/shops/{identifier}")
	public @ResponseBody ResponseEntity<ShopDTO> getShopByIdentifier(@PathVariable("identifier") String identifier) {
		ShopDTO shop = shopService.findShopByIdentifier(identifier);
		return ResponseEntity.ok(shop);
	}
	
	@DeleteMapping("/{shopId}")
	public @ResponseBody ResponseEntity<ShopDTO> deleteShopById(@PathVariable("shopId") Long shopId) {
		ShopDTO shop = shopService.deleteShopById(shopId);
		return ResponseEntity.ok(shop);
	}
}
