package com.springboot.api.services;



import java.util.List;
import java.util.Optional;

import com.springboot.api.resource.exceptions.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.entities.Address;
import com.springboot.api.repositories.AddressRepository;

@Service
public class AddressService {
	
	private final AddressRepository repository;

	public AddressService(AddressRepository repository) {
		this.repository = repository;
	}

	public List<Address> findAll() {
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> address = repository.findById(id);
		return address.orElseThrow(() -> new AddressNotFoundException(id));
	}
	
	public Address insert(Address address) {
		return repository.save(address);
	}

}