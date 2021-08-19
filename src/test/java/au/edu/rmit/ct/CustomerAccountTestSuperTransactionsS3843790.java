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
		TestAccount = new CustomerAccount(1001, 2512, 800, 1000, "Satou", "Kazuma", 920178);
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
		@DisplayName("3. Available Balance is unchanged when money is credited to account")
		void Credit_AvailableBalanceUpdated_MoneyIsCreditedToAccount() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.credit(500.15);

			assertEquals(800, TestAccount.getAvailableBalance(), "Expect 800 after transaction");
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
	//Assumptions Made:
	/**
	 * While the Withdrawal class does not permit overdrawing and account, most banks to allow it and these tests may
	 * serve as a test for future feature implementations.
	 *
	 * The Bank will honour a transaction even if it overdraws an account
	 * When the account is overdrawn, no further debits can take place
	 * For this case, assuming banks will not charge a dishonour fee for overdrawing the account
	 */
	@Nested
	class NestedTestsForCustomerAccountWithEdgeCases{
		@Test
		@DisplayName("6. Available Balance is updated where there not enough money to cover a debit")
		void Debit_AvailableBalanceUpdated_InSufficientFundsToCoverDebit() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1200);

			assertEquals(-400, TestAccount.getAvailableBalance(), "Expect -400 after account is overdrawn");
		}

		@Test
		@DisplayName("7. Total Balance is updated where there not enough money to cover a debit")
		void Debit_TotalBalanceUpdated_InSufficientFundsToCoverDebit() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1200);

			assertEquals(-200, TestAccount.getTotalBalance(), "Expect -200 after account is overdrawn");
		}

		@Test
		@DisplayName("8. Available Balance is unchanged when money is credited to overdrawn account")
		void Debit_AvailableBalanceUpdated_AccountIsOverdrawn() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1200);
			TestAccount.credit(300);

			assertEquals(-400, TestAccount.getAvailableBalance(), "Expect -400 after transaction");
		}

		@Test
		@DisplayName("9. Total Balance is updated when money is credited to overdrawn account")
		void Debit_TotalBalanceUpdated_AccountIsOverdrawn() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1200);
			TestAccount.credit(300);

			assertEquals(100, TestAccount.getTotalBalance(), "Expect 100 after transaction");
		}

		@Test
		@DisplayName("10. Available Balance is unchanged when money is credited to overdrawn account")
		void Credit_AvailableBalanceUpdated_AccountIsStillOverdrawn() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1400);
			TestAccount.credit(300);

			assertEquals(-600, TestAccount.getAvailableBalance(), "Expect -600 after transaction");
		}

		@Test
		@DisplayName("11. Total Balance is updated when money is credited to overdrawn account")
		void Credit_TotalBalanceUpdated_AccountIsStillOverdrawn() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1400);
			TestAccount.credit(300);

			assertEquals(-100, TestAccount.getTotalBalance(), "Expect -100 after transaction");
		}

		@Test
		@DisplayName("12. Throws exception when trying to debit from overdrawn account")
		void Credit_ThrowsException_DebitAnOverdrawnAccount() throws Exception {
			SetUpCustomerAccountTestData();
			TestAccount.debit(1400);

			assertThrows(Exception.class, () -> TestAccount.debit(500), "Expect exception thrown" );
		}

	}

}
