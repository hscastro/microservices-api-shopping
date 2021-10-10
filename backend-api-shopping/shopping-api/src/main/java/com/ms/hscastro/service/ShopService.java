package com.ms.hscastro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hscastro.dto.ShopDTO;
import com.ms.hscastro.entities.Shop;
import com.ms.hscastro.repositories.ShopRepository;

@Service @Transactional(readOnly = false)
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	
	public ShopDTO saveShop(ShopDTO productDTO) {
		ShopDTO newProductDTO = ShopDTO.convertToDTO(
				shopRepository.save(Shop.convertToShop(productDTO)));
		return newProductDTO;
	}

	@Transactional(readOnly = true)
	public List<ShopDTO> listAllShops() {
		List<Shop> lista = shopRepository.findAll(); 
		
		return lista
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ShopDTO> listShopByCategoryId(Long categoryId) {
		List<Shop> lista = shopRepository.getShopByCategoryId(categoryId);
		
		return lista
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ShopDTO findShopById(Long id) {
		Optional<Shop> shop = shopRepository.findById(id);
		if(shop.isPresent()) {
			return ShopDTO.convertToDTO(shop.get());
		}		
		return null;
	}
	
	@Transactional(readOnly = true)
	public ShopDTO findShopByIdentifier(String identifier) {
		Optional<Shop> shop = shopRepository.findByIdentifier(identifier);
		if(shop.isPresent()) {
			return ShopDTO.convertToDTO(shop.get());
		}		
		return null;		
	}
	
		
	public ShopDTO deleteShopById(Long id) {
		Optional<Shop> product = shopRepository.findById(id);
		if(product.isPresent()) {
			shopRepository.delete(product.get());
			return ShopDTO.convertToDTO(product.get());
		}		
		return null;
	}

}
