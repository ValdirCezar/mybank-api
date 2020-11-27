package com.valdir.mybank.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.domain.User;
import com.valdir.mybank.dtos.TransactionDTO;
import com.valdir.mybank.services.TransactionService;
import com.valdir.mybank.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Return all transactions")
	@ApiResponse(code = 200, message = "Success method return")
	@GetMapping
	public ResponseEntity<List<TransactionDTO>> findAll() {
		List<Transaction> list = service.findAll();
		List<TransactionDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@ApiOperation(value = "Return a transactions by id")
	@ApiResponse(code = 200, message = "Success method return")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TransactionDTO> findById(@PathVariable Integer id) {
		Transaction obj = service.findById(id);
		TransactionDTO objDTO = service.fromDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@ApiOperation(value = "Return all transactions by id from user")
	@ApiResponse(code = 200, message = "Success method return")
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<List<TransactionDTO>> findByUser(@PathVariable Integer id) {
		User user = userService.findById(id);
		List<Transaction> list = service.findByUser(user);
		List<TransactionDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
