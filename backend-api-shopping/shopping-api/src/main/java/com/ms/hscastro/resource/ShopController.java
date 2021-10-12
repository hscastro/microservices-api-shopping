package com.ms.hscastro.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hscastro.dto.ShopDTO;
import com.ms.hscastro.dto.ShopReportDTO;
import com.ms.hscastro.service.ShopService;

@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	
	@GetMapping("/shopping")
	public ResponseEntity<List<ShopDTO>> getShops() {
		List<ShopDTO> lista = shopService.listAllShops();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/shopping/{id}")
	public ResponseEntity<ShopDTO> getShopById(@PathVariable("id") Long id) {
		ShopDTO shop = shopService.findById(id);
		return ResponseEntity.ok(shop);
	}

	@GetMapping("/shopping/shopByUser/{identifier}")
	public ResponseEntity<List<ShopDTO>> getShopsByUsers(@PathVariable("identifier") String identifier) {
		List<ShopDTO> shops = shopService.listShopByUser(identifier);
		return ResponseEntity.ok(shops);
	}
	
	@PostMapping("/shopping")
	public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO) {
		ShopDTO newShop = shopService.saveShop(shopDTO);
		return ResponseEntity.ok(newShop);
	}
	
	@GetMapping("/shopping/search")
	public ResponseEntity<List<ShopDTO>> getShopByFilter(
			@RequestParam(name = "dataInicio", required = true)
			@DateTimeFormat(pattern = "dd/MM//yyyy") Date dataInicio,
			@RequestParam(name = "dataFim", required = true)
			@DateTimeFormat(pattern = "dd/MM//yyyy") Date dataFim,
			@RequestParam(name = "valorMinimo", required = true) Float valorMinimo) {
		
		return ResponseEntity.ok(shopService.getShopsByFilters(dataInicio, dataFim, valorMinimo));
	}
	
	@GetMapping("/shopping/report")
	public ResponseEntity<ShopReportDTO> getReportByDate(
			@RequestParam(name = "dataInicio", required = true)
			@DateTimeFormat(pattern = "dd/MM//yyyy") Date dataInicio,
			@RequestParam(name = "dataFim", required = true)
			@DateTimeFormat(pattern = "dd/MM//yyyy") Date dataFim) {
		
		return ResponseEntity.ok(shopService.getReportByDate(dataInicio, dataFim));
	}
	
}
