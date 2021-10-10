package com.ms.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
