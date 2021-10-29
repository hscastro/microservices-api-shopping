package com.ms.hscastro.converter;

import java.util.stream.Collectors;

import com.ms.hscastro.dto.ItemDTO;
import com.ms.hscastro.dto.ShopDTO;
import com.ms.hscastro.entities.Item;
import com.ms.hscastro.entities.Shop;


public class DTOConverter {
	
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setPrice(item.getPrice());
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		return itemDTO;
	}
	
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setData(shop.getDate());
		shopDTO.setItems(
		  shop.getItems()
		  .stream()
		  .map(DTOConverter::convert)
		  .collect(Collectors.toList()));
		
		
		return shopDTO;
	}
	
	

}
