package com.priceminister.account;

import java.math.BigDecimal;

/**
 * This class represents a simple account. It doesn't handle different
 * currencies, all money is supposed to be of standard currency EUR.
 * 
 */
/*
 * I remove the withdraw method because it contains a business concept all
 * classes which implement this interface have one responsibility data of an
 * account and simple operations on the balance without any other object to
 * reduce coupling between account and account rule
 */

public interface Account {

	/**
	 * Adds money to this account.
	 * 
	 * @param addedAmount - the money to add
	 * @throws IllegalAmountException
	 */
	public void add(BigDecimal addedAmount);

	/**
	 * Gets the current account balance.
	 * 
	 * @return the account's balance
	 */
	public BigDecimal getBalance();

}
