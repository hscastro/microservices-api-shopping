package com.ms.hscastro.entities;


import com.ms.hscastro.dto.ItemDTO;


public class Item {
	
	private String productIdentifier;	
	
	private float price;
	
	
	public Item() {
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

	public static Item convertToItem(ItemDTO itemDTO) {
		Item item = new Item();
		item.setProductIdentifier(itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		return item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((productIdentifier == null) ? 0 : productIdentifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (productIdentifier == null) {
			if (other.productIdentifier != null)
				return false;
		} else if (!productIdentifier.equals(other.productIdentifier))
			return false;
		return true;
	}
	
}
