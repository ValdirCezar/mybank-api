package com.valdir.mybank.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.domain.User;
import com.valdir.mybank.dtos.UserDTO;
import com.valdir.mybank.repositories.TransactionRepository;
import com.valdir.mybank.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User insert(UserDTO obj) {
		User newObj = new User(null, obj.getName(), obj.getCpf(), obj.getLogin(), obj.getPassword(), obj.getBalance());
		return repository.save(newObj);
	}
	
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.orElse(null);
	}

	public Transaction makeWithdrawal(User user, Double value) {
		if(user.makeWithdrawal(value)) {
			Transaction transaction =  new Transaction(null, LocalDateTime.now(), true, false, value, user.getBalance() + value, user.getBalance(), "Successful transaction", user);
			repository.save(user);
			transactionRepository.save(transaction);
			return transaction;
		} else {
			Transaction transaction =  new Transaction(null, LocalDateTime.now(), true, false, value, user.getBalance(), user.getBalance(), "Error, transaction not aproved", user);
			transactionRepository.save(transaction);
			return transaction;
		}
	}

	public UserDTO fromDTO(User obj) {
		return new UserDTO(obj);
	}

}
