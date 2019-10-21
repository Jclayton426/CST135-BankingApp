package edu.gcu.bootcamp.cst135.milestone.controller;

import java.util.ArrayList;
import java.util.Scanner;

import edu.gcu.bootcamp.cst135.milestone.model.Customer;
import edu.gcu.bootcamp.cst135.milestone.model.Transaction;

public class Bank {

	Scanner scanner = new Scanner(System.in);
	private Customer firstCustomer = new Customer("Hello", "itsme", "username", "password");
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	private void processCustomerLogin(int option) {
		switch (option) {
		case 1:
			viewCustomerLoginMenu();
			break;
		case 2:
			viewExitScreen();
			break;
		default:
			loginScreen();
		}
	}

	private void viewCustomerLoginMenu() {
		System.out.println("=======================");
		System.out.println("Main Menu - Customers");
		System.out.println("=======================");
		System.out.println("Enter Username:");
		System.out.println("Enter Password:");
		processUsernameAndPassword();
	}

	public void loginScreen() {
		System.out.println("=======================");
		System.out.println("Main Menu");
		System.out.println("=======================");
		System.out.println("1: Login");
		System.out.println("2: Exit Bank");
		int option = getUserMenuChoice();
		processCustomerLogin(option);
	}

	private void processUsernameAndPassword() {
		String username = scanner.nextLine();
		String password = scanner.nextLine();
		if (username.equals(firstCustomer.getUsername()) && password.equals(firstCustomer.getPassword())) {
			viewCustomerMenu();
		} else {
			System.out.println("Username and Password do not match. Please try again");
			loginScreen();
		}
	}

	private void addTransaction(Transaction tran) {
		transactions.add(tran);
	}

	private void viewExitScreen() {
		System.out.println("Goodbye, Have a good day!");
	}

	public void viewCustomerMenu() {

		int option;
		do {
			System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("                MAIN MENU");
			System.out.println("                GCU BANK");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Pick an option: ");
			System.out.println("-----------------------");
			System.out.println(" 1: Deposit to Checking");
			System.out.println(" 2: Deposit to Savings");
			System.out.println(" 3: Withdraw from Checking");
			System.out.println(" 4: Withdraw from Savings");
			System.out.println(" 5: Get balance");
			System.out.println(" 6: Get monthly statement");
			System.out.println("------------------------");
			System.out.println(" 9: : Logout");
			option = getUserMenuChoice();
			processCustomerMenu(option);
		} while (option != 9);
	}

	private int getUserMenuChoice() {
		boolean success = false;
		int result = 0;
		while (!success) {
			String option = scanner.nextLine();
			success = true;
			try {
				result = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Expecting a numeric menu choice.  Please try again.");
				success = false;
			}
		}
		return result;
	}

	private double getUserAmount() {
		boolean success = false;
		double result = 0;
		while (!success) {
			String option = scanner.nextLine();
			success = true;
			try {
				result = Double.parseDouble(option);
			} catch (NumberFormatException e) {
				System.out.println("Input Error Expecting a numeric menu choice.  Please try again.*");
				success = false;
			}
		}
		return result;
	}

	private void processCustomerMenu(int parseInt) {

		switch (parseInt) {
		case 1:
			viewDepositChecking();
			viewBalances();
			break;
		case 2:
			viewDepositSavings();
			viewBalances();
			break;
		case 3:
			viewWithdrawalChecking();
			viewBalances();
			break;
		case 4:
			viewWithdrawalSavings();
			viewBalances();
			break;
		case 5:
			viewBalances();
			break;
		case 6:
			viewEndOfMonth();
			viewBalances();
			break;
		case 9:
			viewExitScreen();
			break;
		default:
			viewCustomerMenu();
		}
	}

	private void viewEndOfMonth() {

		System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("               END OF MONTH");
		System.out.println("                 GCU BANK");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

		if (firstCustomer.saving.getAccountBalance() < firstCustomer.saving.getMinBalance()) {
			System.out.printf("A $%.2f service fee is being assessed for below minimum balance in savings",
					firstCustomer.saving.getServiceFee());
			firstCustomer.saving
					.setAccountBalance(firstCustomer.saving.getAccountBalance() - firstCustomer.saving.getServiceFee());
		}
		if (firstCustomer.saving.getAccountBalance() > 0) {
			firstCustomer.saving.setAccountBalance(firstCustomer.saving.getAccountBalance()
					+ (firstCustomer.saving.getInterest() * firstCustomer.saving.getAccountBalance()));

		}

		displayTransactions();

	}

	public void displayTransactions() {
		System.out.println("\n-----------SESSION TRANSACTIONS------------");
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
		System.out.println("-------------------------------------------");
	}

	private void viewWithdrawalChecking() {

		System.out.println("How much would you like to withdraw: ");
		double input = getUserAmount();

		scanner.nextLine();
		processWithdrawalChecking(input);
		addTransaction(new Transaction(input, firstCustomer.checking.getAccountNumber(), "Withdraw"));

	}

	private void processWithdrawalChecking(double input) {

		if (firstCustomer.checking.getAccountBalance() < input) {
			System.out.println("A $" + firstCustomer.checking.getOverdraft()
					+ " overdraft fee will be assessed if you continue. Continue Y or N?");
			if (scanner.nextLine().toLowerCase().equals("y")) {
				firstCustomer.checking.setAccountBalance(
						firstCustomer.checking.getAccountBalance() - input - firstCustomer.checking.getOverdraft());
			} else
				viewWithdrawalChecking();
		} else
			firstCustomer.checking.setAccountBalance(firstCustomer.checking.getAccountBalance() - input);
	}

	private void viewDepositSavings() {

		System.out.println("How much would you like to deposit: ");

		double input = getUserAmount();

		scanner.nextLine();
		processDepositSavings(input);
		addTransaction(new Transaction(input, firstCustomer.saving.getAccountNumber(), "Withdraw"));
	}

	private void processDepositSavings(double input) {

		firstCustomer.saving.setAccountBalance(firstCustomer.saving.getAccountBalance() + input);
	}

	private void viewDepositChecking() {

		System.out.println("How much would you like to deposit: ");

		double input = getUserAmount();

		scanner.nextLine();
		processDepositChecking(input);
		addTransaction(new Transaction(input, firstCustomer.checking.getAccountNumber(), "Deposit"));
	}

	private void processDepositChecking(double input) {

		firstCustomer.checking.setAccountBalance(firstCustomer.checking.getAccountBalance() + input);
	}

	private void viewWithdrawalSavings() {

		System.out.println("How much would you like to withdraw: ");

		double input = getUserAmount();

		scanner.nextLine();
		processWithdrawalSavings(input);
		addTransaction(new Transaction(input, firstCustomer.saving.getAccountNumber(), "Withdraw"));
	}

	private void processWithdrawalSavings(double input) {

		firstCustomer.saving.setAccountBalance(firstCustomer.saving.getAccountBalance() - input);
	}

	private void viewBalances() {

		System.out.println("\n------------------------");
		System.out.println(firstCustomer.saving.toString());
		System.out.println(firstCustomer.checking.toString());
		System.out.println("------------------------");
	}

}
