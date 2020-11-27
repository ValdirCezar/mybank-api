package com.valdir.mybank.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh/MM/ss")
	private LocalDateTime dateOfTransaction;
	
	private Boolean isItWithdraw;
	private Boolean isItDeposit;
	private Double valueOfTransaction;
	private Double balanceBeforeTransaction;
	private Double balanceAfterTransaction;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Transaction() {
		super();
	}

	public Transaction(Integer id, LocalDateTime dateOfTransaction, Boolean isItWithdraw, Boolean isItDeposit,
			Double valueOfTransaction, Double balanceBeforeTransaction, Double balanceAfterTransaction, User user) {
		super();
		this.id = id;
		this.dateOfTransaction = dateOfTransaction;
		this.isItWithdraw = isItWithdraw;
		this.isItDeposit = isItDeposit;
		this.valueOfTransaction = valueOfTransaction;
		this.balanceBeforeTransaction = balanceBeforeTransaction;
		this.balanceAfterTransaction = balanceAfterTransaction;
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public Boolean getIsItWithdraw() {
		return isItWithdraw;
	}

	public void setIsItWithdraw(Boolean isItWithdraw) {
		this.isItWithdraw = isItWithdraw;
	}

	public Boolean getIsItDeposit() {
		return isItDeposit;
	}

	public void setIsItDeposit(Boolean isItDeposit) {
		this.isItDeposit = isItDeposit;
	}

	public Double getValueOfTransaction() {
		return valueOfTransaction;
	}

	public void setValueOfTransaction(Double valueOfTransaction) {
		this.valueOfTransaction = valueOfTransaction;
	}

	public Double getBalanceBeforeTransaction() {
		return balanceBeforeTransaction;
	}

	public void setBalanceBeforeTransaction(Double balanceBeforeTransaction) {
		this.balanceBeforeTransaction = balanceBeforeTransaction;
	}

	public Double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}

	public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
