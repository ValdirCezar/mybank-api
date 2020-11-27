package com.valdir.mybank.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
