package com.valdir.mybank.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.dtos.TransactionDTO;
import com.valdir.mybank.services.TransactionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	@ApiOperation(value = "Return all transactions")
	@ApiResponse(code = 200, message = "Success method return")
	@GetMapping
	public ResponseEntity<List<TransactionDTO>> findAll() {
		List<Transaction> list = service.findAll();
		List<TransactionDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
