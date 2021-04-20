package com.springboot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByCpf(String cpf);
   Optional<User> findByEmail(String email);
	
}
