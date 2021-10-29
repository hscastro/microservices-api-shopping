package com.ms.hscastro.dto;



import com.ms.hscastro.entities.Item;


public class ItemDTO {

	private String productIdentifier;	
	
	private float price;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
		
	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setPrice(item.getPrice());
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		return itemDTO;
	}
	
}
