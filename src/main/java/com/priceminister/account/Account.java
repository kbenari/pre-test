package com.priceminister.account;

import java.math.BigDecimal;

/**
 * This class represents a simple account. It doesn't handle different
 * currencies, all money is supposed to be of standard currency EUR.
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
