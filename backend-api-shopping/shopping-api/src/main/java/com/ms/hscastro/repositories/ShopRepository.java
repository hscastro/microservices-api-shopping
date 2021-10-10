package com.ms.hscastro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	List<Shop> findAllByUsersIdentifier(String userIdentified);
	
	List<Shop> findAllByTotalGreaterThan(float total);
	
	List<Shop> findAllBydateGreaterThan(Date date);
}
