package edu.gcu.bootcamp.cst135.milestone.model;

import java.util.Date;

public class Customer {
	public Saving saving = new Saving("-SAV12345", 5000, 200, 25, .06);
	public Checking checking = new Checking("-CHK23456", 5000, 25);

	private String Firstname;
	private String lastName;
	private String username;
	private String password;
	private Date dateOpened;

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Customer(String firstname, String lastName, String username, String password) {
		super();
		Firstname = firstname;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
}
