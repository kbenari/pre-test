/**
 * 
 */
package com.priceminister.account.implementation;

import java.math.BigDecimal;

import com.google.inject.Inject;
import com.priceminister.account.AccountManager;
import com.priceminister.account.AccountRule;
import com.priceminister.account.exception.IllegalBalanceException;

/**
 * @author kben
 *
 */

public class CustomerAccountManager implements AccountManager<CustomerAccount> {

	@Inject
	private AccountRule accountRule; 
	
	@Override
	public BigDecimal withdrawAndReportBalance(CustomerAccount account, BigDecimal withdrawnAmount)
			throws IllegalBalanceException {
		
				
		BigDecimal resultingAccountBalance = account.getBalance().subtract(withdrawnAmount);
		if (!accountRule.withdrawPermitted(resultingAccountBalance))
			throw new IllegalBalanceException(resultingAccountBalance);
		
		account.add(withdrawnAmount.negate());
		
		return resultingAccountBalance;
	}

}
