package com.ms.hscastro.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ms.hscastro.dto.ShopDTO;


@Entity(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private float total;
		
	@Column
	private String userIdentifier;
	
	private Date data;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(Long id, float total, String userIdentifier, Date data) {
		super();
		this.id = id;
		this.total = total;
		this.userIdentifier = userIdentifier;
		this.data = data;
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

	public static Shop convertToShop(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setId(shopDTO.getId());
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		shop.setData(shopDTO.getData());
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
