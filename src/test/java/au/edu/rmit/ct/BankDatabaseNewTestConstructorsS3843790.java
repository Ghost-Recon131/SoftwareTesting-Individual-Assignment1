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

import java.util.ArrayList;

/*
 * Please replace S3214321 of class name with your own student number
 */
class BankDatabaseNewTestConstructorsS3214321 {
	private BankDatabaseNew BankDatabaseTest; //class variable used for testing BankDatabaseNew
	private CustomerAccount TestCustomerAccount;
	private CustomerAccount TestCustomerAccount2;

	// create test data for BankDatabaseNew
	void SetUpBankDatabaseTestData() throws Exception {
		BankDatabaseTest = new BankDatabaseNew();
	}

	// create test data for Customer Accounts
	void SetUpCustomerAccountTestData() throws Exception {
		TestCustomerAccount = new CustomerAccount(100, 1234, 100, 2000, "Doe", "John", 12340);
		TestCustomerAccount2 = new CustomerAccount(101, 7890, 40, 10000, "Bosak", "Ela", 38590);
	}

	// send test objects to garbage collector, so they can be created again for testing
	@AfterEach
	void tearDown() throws Exception {
		BankDatabaseTest = null;
		TestCustomerAccount = null;
		TestCustomerAccount2 = null;
	}

	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest
	@Test
	@DisplayName("1. Test Default Constructor") //tests that the default constructor is working
	void BankDatabaseNew_SuccessfullyCreated_DefaultConstructor() throws Exception {
		SetUpBankDatabaseTestData();
		assertTrue(BankDatabaseTest.isEmpty(), "Expect true");
	}

	@Test
	@DisplayName("2. Test CustomerAccountConstructor")
		//tests that the default constructor is working
	void CustomerAccount_SuccessfullyCreated_CreateCustomerObject() throws Exception {
		SetUpCustomerAccountTestData();
		assertEquals("John", TestCustomerAccount.getGivenName(), "Expect true");

		TestCustomerAccount.setGivenName("Johnn"); //make small change

		assertEquals("Johnn", TestCustomerAccount.getGivenName(), "Expect true");
	}

	@Test
	@DisplayName("3. Test BankDatabaseNew Constructor")
	void BankDatabaseNew_SuccessfullyCreated_Constructor() throws Exception {
		SetUpCustomerAccountTestData();
		ArrayList<CustomerAccount> AccountArraylist = new ArrayList<>();
		AccountArraylist.add(TestCustomerAccount); // create arraylist & add 1 customer account into it
		AccountArraylist.add(TestCustomerAccount2);

		BankDatabaseNew BankDatabaseConstructorTest = new BankDatabaseNew(AccountArraylist); //add to constructor
		assertEquals(2, BankDatabaseConstructorTest.size(), "Expect 1");
 	}

 	@Test
	@DisplayName("4. Test add works when adding a valid account")
	void add_AddsCustomerAccount_ValidAccountIsAdded() throws Exception {
		SetUpBankDatabaseTestData();
		SetUpCustomerAccountTestData();
		BankDatabaseTest.add(TestCustomerAccount); //checks account is added to arraylist

		assertEquals(1, BankDatabaseTest.size(),"Expect 1");

		BankDatabaseTest.add(TestCustomerAccount2); //verify adding more accounts does not cause a problem
		assertEquals(2, BankDatabaseTest.size(),"Expect 2");
	}

	@Test
	@DisplayName("5. Test add method throws an exception when adding a duplicate customer")
	void add_ThrowsException_DuplicateAccountIsAdded() throws Exception {
		SetUpBankDatabaseTestData();
		SetUpCustomerAccountTestData();
		BankDatabaseTest.add(TestCustomerAccount);

		assertThrows(
				Exception.class, () -> BankDatabaseTest.add(TestCustomerAccount), //adds the same customer again
				"Expect an exception"
		);
	}

	@Test //cannot use assertThrows on creating an object via constructor, thus using try / catch block instead
	@DisplayName("6. CustomerAccount constructor throws an exception on short pin")
	void CustomerAccount_ThrowsException_PinTooShort() {
		assertThrows(
				Exception.class, () -> new CustomerAccount(105, 567, 100, 10000, "Miyazono", "Kaori", 123789)
		);
	}

	@Test
	@DisplayName("7. CustomerAccount constructor throws an exception on long pin")
	void CustomerAccount_ThrowsException_PinTooLong(){
		assertThrows(
				Exception.class, () -> new CustomerAccount(1010, 56789, 2000, 2000, "Tachibana", "Kanade", 244650)
		);
	}

}
