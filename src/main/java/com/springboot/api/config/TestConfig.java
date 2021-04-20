package com.springboot.api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.api.entities.Address;
import com.springboot.api.entities.User;
import com.springboot.api.repositories.AddressRepository;
import com.springboot.api.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	private final UserRepository userRepository;
	
	private final AddressRepository addressRepository;

	public TestConfig(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99142082234", sdf.parse("29/09/1989"));
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "00885644280", sdf.parse("26/10/1992")); 
		
		Address a1 = new Address(null, "68040-520", "Travessa Barjonas de Miranda", 604,
				"Entre Mendonça e Presidente", "Aldeia", "Santarém", "PA", u1);;
		Address a2 = new Address(null, "68020-560", "Avenida Barão do Rio Branco", 260,
				"Entre Rui Barbosa e Presidente", "Centro", "Santarém", "PA", u2);;
		Address a3 = new Address(null, "68060-580", "Travessa Barjonas de Miranda", 604,
				"Entre Rui Barjosa e 15 de Agosto", "Centro", "Santarém", "PA", u1);;

		userRepository.saveAll(Arrays.asList(u1, u2));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		
	}
}