package com.valdir.mybank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.domain.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findByUser(User user);
}
