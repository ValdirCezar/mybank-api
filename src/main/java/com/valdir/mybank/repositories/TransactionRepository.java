package com.valdir.mybank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdir.mybank.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
