package edu.gcu.bootcamp.cst135.milestone.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class CheckingTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOverdraft() {
		final double overDraft = 50.40;
		Checking checking = new Checking("TEST", 0, overDraft);

		assertEquals("Overdraft test fails", checking.getOverdraft(), overDraft, 0.001);
	}

	@Test
	public void testSetOverdraft() {
		final double overDraft = 50.40;
		Checking checking = new Checking("TEST", 0, overDraft);
		checking.setOverdraft(overDraft * 2);

		assertEquals("Overdraft test fails", checking.getOverdraft(), overDraft * 2, 0.001);
	}

	@Test
	public void testGetAccountNumber() {
		final String accountNumber = "TEST";
		Checking checking = new Checking(accountNumber, 0, 0);
		assertEquals("getAccountNumber test fails", checking.getAccountNumber(), accountNumber);

	}

	@Test
	public void testSetAccountNumber() {
		final String accountNumber = "TEST";
		Checking checking = new Checking(accountNumber, 0, 0);
		checking.setAccountNumber(accountNumber);
		assertEquals("getAccountNumber test fails", checking.getAccountNumber(), accountNumber);

	}

	@Test
	public void testGetAccountBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAccountBalance() {
		fail("Not yet implemented");
	}

}
