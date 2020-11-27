package com.valdir.mybank.dtos;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String cpf;
	private String login;
	private String password;
	private Double balance;

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String name, String cpf, String login, String password, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.login = login;
		this.password = password;
		this.balance = balance;
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
