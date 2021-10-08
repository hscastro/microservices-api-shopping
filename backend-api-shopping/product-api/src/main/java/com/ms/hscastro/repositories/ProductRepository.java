package com.ms.hscastro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByIdentifier(String identified);
	
	@Query(value = "select p.nome, p.preco, "
			+ "p.identifier, p.descricao, "
			+ "from product p"
			+ "join category c on p.category.id = c.id"
			+ "where c.id =:categoryId ")
	List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);
	
	Product findByProductIdentifier(String identified);
}
