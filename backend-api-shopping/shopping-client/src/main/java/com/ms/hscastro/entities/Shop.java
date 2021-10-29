package com.ms.hscastro.entities;


import java.util.Date;
import java.util.List;
import com.ms.hscastro.dto.ShopDTO;


public class Shop {

	private Long id;
	
	private float total;
		
	private String userIdentifier;
	
	private Date date;
	
	private List<Item> items;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(Long id, float total, String userIdentifier, Date date, List<Item> items) {
		super();
		this.id = id;
		this.total = total;
		this.userIdentifier = userIdentifier;
		this.date = date;
		this.items = items;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static Shop convertToShop(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setId(shopDTO.getId());
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		shop.setDate(shopDTO.getData());	
//		shop.setItems(shopDTO
//				.getItems()
//				.stream()
//				.map(Item::convertToItem)
//				.collect(Collectors.toList()));
		return shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Shop other = (Shop) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
			
}
