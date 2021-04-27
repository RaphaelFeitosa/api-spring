package com.springboot.api.resource;

import com.springboot.api.entities.User;
import com.springboot.api.entities.dto.UserDTO;
import com.springboot.api.resource.exceptions.ValidateCpfException;
import com.springboot.api.resource.exceptions.ValidateEmailException;
import com.springboot.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = this.userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = this.userService.findById(id);
		return ResponseEntity.ok().body(user);

	}

	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserDTO userDTO) {

		 if (this.userService.validateCpf(userDTO.getCpf())){
			throw new ValidateCpfException(userDTO.getCpf());
		 }

		 if (this.userService.validateEmail(userDTO.getEmail())){
			throw new ValidateEmailException(userDTO.getEmail());

		 }
		 User user = this.userService.insert(userDTO.toUser());
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		 return ResponseEntity.created(uri).body(new UserDTO(user));
	}

}
