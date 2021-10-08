package com.ms.hscastro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByIdentifier(String identified);
}
