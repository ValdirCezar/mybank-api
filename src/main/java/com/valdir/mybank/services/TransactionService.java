package com.valdir.mybank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.domain.User;
import com.valdir.mybank.dtos.TransactionDTO;
import com.valdir.mybank.repositories.TransactionRepository;
import com.valdir.mybank.services.exceptions.ObjectNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public List<Transaction> findAll() {
		return repository.findAll();
	}

	public Transaction findById(Integer id) {
		Optional<Transaction> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Transaction.class.getName()));
	}
	
	public List<Transaction> findByUser(User user) {
		return repository.findByUser(user);
	}

	public TransactionDTO fromDTO(Transaction obj) {
		return new TransactionDTO(obj);
	}

}
