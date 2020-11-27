package com.valdir.mybank.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.valdir.mybank.domain.Transaction;

public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDateTime dateOfTransaction;
	private Boolean isItWithdraw;
	private Boolean isItDeposit;
	private Double valueOfTransaction;
	private Double balanceBeforeTransaction;
	private Double balanceAfterTransaction;
	private String message;

	public TransactionDTO() {
		super();
	}

	public TransactionDTO(Transaction obj) {
		super();
		this.id = obj.getId();
		this.dateOfTransaction = obj.getDateOfTransaction();
		this.isItWithdraw = obj.getIsItWithdraw();
		this.isItDeposit = obj.getIsItDeposit();
		this.valueOfTransaction = obj.getValueOfTransaction();
		this.balanceBeforeTransaction = obj.getBalanceBeforeTransaction();
		this.balanceAfterTransaction = obj.getBalanceAfterTransaction();
		this.message = obj.getMessage();
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
