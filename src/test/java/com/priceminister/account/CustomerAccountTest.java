package com.priceminister.account;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.priceminister.account.implementation.CustomerAccount;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertTrue( BigDecimal.ZERO.compareTo(customerAccount.getBalance())==0);
        
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	BigDecimal addedAmount = new BigDecimal(20);
    	customerAccount.add(addedAmount);
    	assertTrue( addedAmount.compareTo(customerAccount.getBalance())==0);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
    	BigDecimal withdrawnAmount = new BigDecimal(20);
    	
    	thrown.expect(IllegalBalanceException.class);
    	customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
		
    	 
    }
    
    // Also implement missing unit tests for the above functionalities.

}
