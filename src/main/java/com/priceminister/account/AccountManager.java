/**
 * 
 */
package com.priceminister.account;

import java.math.BigDecimal;


import com.priceminister.account.exception.IllegalBalanceException;

/**
 * @author kben
 * this class manage operation on the account 
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

    //TODO add other methods like add amount ( i keep it like this to respect Kiss and YAGNI)
   
    

}
