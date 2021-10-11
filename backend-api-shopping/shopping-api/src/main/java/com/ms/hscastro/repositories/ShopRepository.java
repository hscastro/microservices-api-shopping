package com.ms.hscastro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	public List<Shop> findAllByUserIdentifier(String userIdentified);
	
	public List<Shop> findAllByTotalGreaterThan(Float total);
	
	public List<Shop> findAllByDateGreaterThan(Date date);
}
