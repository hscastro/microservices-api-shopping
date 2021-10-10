package com.ms.hscastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	
	@GetMapping("/shopping")
	public @ResponseBody ResponseEntity<List<ShopDTO>> getShops() {
		List<ShopDTO> lista = shopService.listAllShops();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/shopping/{id}")
	public @ResponseBody ResponseEntity<ShopDTO> getShopById(@PathVariable("id") Long id) {
		ShopDTO shop = shopService.findById(id);
		return ResponseEntity.ok(shop);
	}

	@GetMapping("/shopping/shopByUser/{identifier}")
	public @ResponseBody ResponseEntity<List<ShopDTO>> getShopsByUsers(@PathVariable("identifier") String identifier) {
		List<ShopDTO> shops = shopService.listShopByUser(identifier);
		return ResponseEntity.ok(shops);
	}
	
	@PostMapping("/shopping")
	public @ResponseBody ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO) {
		ShopDTO newShop = shopService.saveShop(shopDTO);
		return ResponseEntity.ok(newShop);
	}
}
