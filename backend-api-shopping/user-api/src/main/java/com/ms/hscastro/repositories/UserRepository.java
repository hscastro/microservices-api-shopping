package com.ms.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hscastro.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
