package com.springboot.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.api.entities.User;
import com.springboot.api.entities.dto.AddressDTO;
import com.springboot.api.resource.exceptions.UserNotFoundException;
import com.springboot.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.api.entities.Address;
import com.springboot.api.services.AddressService;


@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	private final AddressService addressService;

	private final UserService userService;

	public AddressResource(AddressService addressService, UserService userService) {
		this.addressService = addressService;
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<Address>> findAll() {
		List<Address> list = this.addressService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address address = this.addressService.findById(id);
		return ResponseEntity.ok().body(address);
	}
	
	@PostMapping
	public ResponseEntity<AddressDTO> insert(@RequestBody @Valid AddressDTO addressDTO) {
		User user = this.userService.findById(addressDTO.getUserId());

		if(user == null) {
			throw new UserNotFoundException(addressDTO.getUserId());
		}
		Address address = this.addressService.insert(addressDTO.toAddress());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(uri).body(new AddressDTO(address));
	}


}
