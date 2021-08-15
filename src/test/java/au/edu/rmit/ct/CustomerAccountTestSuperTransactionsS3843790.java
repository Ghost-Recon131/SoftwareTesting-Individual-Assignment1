/**
*  
* Name: John Smith
* Student ID: s45045012
* Email: s45045012@student.rmit.edu.au
* 
* [OPTIONAL: add any notes here about the code]
*/
package au.edu.rmit.ct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/*
 * Please replace S3214321 of class name with your own student number
 */

class CustomerAccountTestSuperTransactionsS3843790 {
	CustomerAccount TestAccount;

	void SetUpCustomerAccountTestData() throws Exception {
		TestAccount = new CustomerAccount(1001, 2512, 800, 1000, "Kazuma", "Satou", 920178);
	}

	@AfterEach
	void tearDown() throws Exception {
		TestAccount = null;
	}

	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest

	// These are nested test cases that evaluate how the program performs during standard conditions ie no edge cases
	@Nested
	class NestedTestsForCustomerAccountDuringStandardOperation{
		@Test
		@DisplayName("1. Available Balance is updated where there is enough money to cover a debit")
		void Debit_AvailableBalanceUpdated_SufficientFundsToCoverDebit() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(300);

			assertEquals(500, TestAccount.getAvailableBalance(), "Expect 500 after transaction");
		}

		@Test
		@DisplayName("2. Total Balance is updated where there is enough money to cover a debit")
		void Debit_TotalBalanceUpdated_SufficientFundsToCoverDebit() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(300);

			assertEquals(700, TestAccount.getTotalBalance(), "Expect 700 after transaction");
		}

		@Test
		@DisplayName("3. Available Balance is updated when money is credited to account")
		void Credit_AvailableBalanceUpdated_MoneyIsCreditedToAccount() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.credit(500.15);

			assertEquals(1300.15, TestAccount.getAvailableBalance(), "Expect 1300.15 after transaction");
		}

		@Test
		@DisplayName("4. Total Balance is updated when money is credited to account")
		void Credit_TotalBalanceUpdated_MoneyIsCreditedToAccount() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.credit(500.15);

			assertEquals(1500.15, TestAccount.getTotalBalance(), "Expect 1500.15 after transaction");
		}

		@Test
		@DisplayName("5. Validate account PIN")
		void validatePIN_ReturnTrue_EnteredPinIsCorrect() throws Exception {
			SetUpCustomerAccountTestData();

			assertTrue(TestAccount.validatePIN(2512), "Returns True");
		}

	}

	// These are nested test cases that evaluate how the program performs when edge cases are introduced
	@Nested
	class NestedTestsForCustomerAccountWithEdgeCases{
		//TODO
	}

}
