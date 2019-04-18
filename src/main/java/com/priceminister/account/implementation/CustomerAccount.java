package com.priceminister.account.implementation;

import java.math.BigDecimal;

import com.priceminister.account.Account;

public class CustomerAccount implements Account {
	private BigDecimal balance = BigDecimal.ZERO;

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}

	@Override
	public void add(BigDecimal addedAmount) {
		this.balance = balance.add(addedAmount);
	}

}
