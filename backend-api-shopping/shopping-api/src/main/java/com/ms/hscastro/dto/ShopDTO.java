package com.ms.hscastro.dto;


import java.util.Date;
import java.util.List;

import com.ms.hscastro.entities.Item;
import com.ms.hscastro.entities.Shop;


public class ShopDTO {

	private Long id;
	private float total;
	private String userIdentifier;	
	private Date data;
	private List<Item> items;
	
	public ShopDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static ShopDTO convertToDTO(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setData(shop.getData());	
		return shopDTO;
	}
	
}
