/**
 * 
 */
package com.priceminister.account;

import java.math.BigDecimal;


import com.priceminister.account.exception.IllegalBalanceException;

/**
 * @author kben
 *
 */
public interface AccountManager<T extends Account> {

	
	/**
     * Withdraws money from the account.
     * @param account  
     * @param withdrawnAmount - the money to withdraw
     * @return the remaining account balance
     * @throws IllegalBalanceException if the withdrawal leaves the account with a forbidden balance
     */
    public BigDecimal withdrawAndReportBalance(T account , BigDecimal withdrawnAmount) throws IllegalBalanceException;

    
   
    

}
