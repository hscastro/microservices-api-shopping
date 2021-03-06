package com.ms.hscastro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hscastro.dto.ShopDTO;
import com.ms.hscastro.dto.ShopReportDTO;
import com.ms.hscastro.entities.Shop;
import com.ms.hscastro.repositories.ShopRepository;

@Service 
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	
	public ShopDTO saveShop(ShopDTO shopDTO) {
		shopDTO.setTotal(shopDTO.getItems()
				.stream()
				.map(x -> x.getPrice())
				.reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convertToShop(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);		
		return ShopDTO.convertToDTO(shop);
	}

	@Transactional(readOnly = true)
	public List<ShopDTO> listAllShops() {
		List<Shop> lista = shopRepository.findAll(); 
		
		return lista
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ShopDTO> listShopByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		
		return shops
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ShopDTO> findShopByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getData());
		
		return shops
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ShopDTO findById(Long id) {
		Optional<Shop> product = shopRepository.findById(id);
		
		if(product.isPresent()) {
			return ShopDTO.convertToDTO(product.get());
		}		
		return null;
	}
	
	@Transactional(readOnly = true)
	public List<ShopDTO> getShopsByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {
		List<Shop> shops = shopRepository
				.getShopByFilters(dataInicio, dataFim, valorMinimo);
		
		return shops
				.stream().map(ShopDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		
		return shopRepository
				.getReportByDate(dataInicio, dataFim);
	}
	
}
