/**
 * 
 */
package com.priceminister.account;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.priceminister.account.exception.IllegalBalanceException;
import com.priceminister.account.implementation.CustomerAccount;
import com.priceminister.account.implementation.CustomerAccountManager;
import com.priceminister.account.implementation.CustomerAccountRule;

/**
 * @author kben
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustumerAccountMangerTest {

	@Inject
	AccountManager<CustomerAccount> customerAccountManager;
	@Inject
	AccountRule rule;
	@Mock
	CustomerAccount customerAccount;

	protected Injector injector = Guice.createInjector(new AbstractModule() {
		@Override
		protected void configure() {

			bind(new TypeLiteral<AccountManager<CustomerAccount>>() {
			}).to(CustomerAccountManager.class);
			bind(AccountRule.class).to(CustomerAccountRule.class);

		}
	});

	@Before
	public void setUp() throws Exception {
		injector.injectMembers(this);
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Tests that an illegal withdrawal throws the expected exception. Use the logic
	 * contained in CustomerAccountRule; feel free to refactor the existing code.
	 */
	@Test(expected = IllegalBalanceException.class)
	public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
		
		Mockito.when(customerAccount.getBalance()).thenReturn(new BigDecimal(10)); 
		BigDecimal withdrawnAmount = new BigDecimal(20);
		
		customerAccountManager.withdrawAndReportBalance(customerAccount, withdrawnAmount);

	}

	/**
	 * Tests that a legal withdrawal return the good balance.
	 */
	@Test
	public void testWithdrawAndReportBalancelegalBalance() throws IllegalBalanceException {
		Mockito.when(customerAccount.getBalance()).thenReturn(new BigDecimal(50));
		BigDecimal withdrawnAmount = new BigDecimal(20);
		BigDecimal expectedAmount = new BigDecimal(30);
		BigDecimal resultAmount = customerAccountManager.withdrawAndReportBalance(customerAccount, withdrawnAmount);

		assertTrue(expectedAmount.compareTo(resultAmount)==0);
	}

}
