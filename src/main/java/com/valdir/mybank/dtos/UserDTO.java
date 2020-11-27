package com.valdir.mybank.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.valdir.mybank.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String login;
	
	@NotBlank
	private String password;
	
	private Double balance;

	public UserDTO() {
		super();
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.login = obj.getLogin();
		this.password = obj.getPassword();
		this.balance = obj.getBalance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
