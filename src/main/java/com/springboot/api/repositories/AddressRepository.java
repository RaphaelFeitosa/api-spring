package com.springboot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
