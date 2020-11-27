package com.valdir.mybank.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdir.mybank.domain.Transaction;
import com.valdir.mybank.domain.User;
import com.valdir.mybank.dtos.UserDTO;
import com.valdir.mybank.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "Return a list of UserDTO")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success method")
	})
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value = "Insert a new User")
	@ApiResponse(code = 201, message = "Created")
	@PostMapping
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserDTO obj) {
		User newObj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		obj = service.fromDTO(newObj);
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Return a UserDTO by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	

}
