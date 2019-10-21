package edu.gcu.bootcamp.cst135.milestone.model;

import java.util.Date;

public class Transaction {
	private double amount;
	private Date transactionDate;
	private String accountName;
	private String type;

	public Transaction(double amount, String accountName, String type) {
		this.amount = amount;
		this.transactionDate = new Date();
		this.accountName = accountName;
		this.type = type;

	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", transactionDate=" + transactionDate + ", accountName=" + accountName
				+ ", type=" + type + "]";
	}

}
