package com.valdir.mybank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.repositories.TransactionRepository;

@Service
public class CategoryService {
	
	@Autowired
	private TransactionRepository repository;
	
	public List<Transaction> findAll() {
		return repository.findAll();
	}

}
