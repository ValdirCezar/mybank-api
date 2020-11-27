package com.valdir.mybank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.mybank.domain.User;
import com.valdir.mybank.dtos.UserDTO;
import com.valdir.mybank.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public UserDTO fromDTO(User obj) {
		return new UserDTO(obj.getId(), obj.getName(), obj.getCpf(), obj.getLogin(), obj.getPassword(), obj.getBalance());
	}
	
}
