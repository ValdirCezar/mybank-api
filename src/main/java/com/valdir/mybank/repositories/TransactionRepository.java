package com.valdir.mybank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.mybank.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
