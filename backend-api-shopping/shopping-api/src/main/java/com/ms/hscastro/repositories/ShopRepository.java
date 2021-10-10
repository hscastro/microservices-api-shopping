package com.ms.hscastro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	Optional<Shop> findByIdentifier(String identified);
	
	@Query(value = "select p.nome, p.preco, "
			+ "p.identifier, p.descricao, "
			+ "from product p"
			+ "join category c on p.category.id = c.id"
			+ "where c.id =:categoryId ")
	List<Shop> getShopByCategoryId(@Param("categoryId") Long categoryId);
	
	Shop findByShopIdentifier(String identified);
}
