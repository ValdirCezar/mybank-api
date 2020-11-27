package com.valdir.mybank;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdir.mybank.domain.User;
import com.valdir.mybank.repositories.UserRepository;

@SpringBootApplication
public class MybankApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null, "Valdir Cezar", "09874185968", "valdir", "123", 0.0);
		
		userRepository.saveAll(Arrays.asList(user));
	}

}
