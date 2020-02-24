package model.entities;

import model.exceptions.WithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		
		balance += amount;
	}
	
	public void withdraw(Double amount) throws WithdrawException {
		if (amount > this.balance)
			throw new WithdrawException("Not enough balance");
		
		if (amount > this.withdrawLimit)
			throw new WithdrawException("The amount exceeds withdraw limit");
		
		balance -= amount;
	}

	public Account() {
	}

	public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = initialBalance;
		this.withdrawLimit = withdrawLimit;
	}
}
