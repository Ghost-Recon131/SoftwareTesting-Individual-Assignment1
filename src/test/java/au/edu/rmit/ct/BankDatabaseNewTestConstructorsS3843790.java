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

	// create/ re-create the testing data before every test to ensure there is no contamination
	@BeforeEach
	void setUp() throws Exception {
		BankDatabaseTest = new BankDatabaseNew();
		TestCustomerAccount = new CustomerAccount(100, 1234, 100, 2000, "Doe", "John", 12340);
		TestCustomerAccount2 = new CustomerAccount(101, 7890, 40, 10000, "Bosak", "Ela", 38590);
	}

	// send test objects to garbage collector, so they can be created again for testing
	@AfterEach
	void tearDown() throws Exception {
		BankDatabaseTest = null;
		TestCustomerAccount = null;
	}

	//Test naming: MethodName_ExpectedBehavior_StateUnderTest
	@Test
	@DisplayName("1. Test Default Constructor") //tests that the default constructor is working
	void BankDatabaseNew_SuccessfullyCreated_DefaultConstructor() {
		try {
			assertTrue(BankDatabaseTest.isEmpty(), "Expect true");
		} catch (Exception e) {
			fail("Exception thrown in constructor"); // fails the test if the constructor throws an exception
		}
	}

	@Test
	@DisplayName("2. Test CustomerAccountConstructor")
		//tests that the default constructor is working
	void CustomerAccount_SuccessfullyCreated_CreateCustomerObject() {
		try {
			assertEquals("John", TestCustomerAccount.getGivenName(), "Expect true");

			TestCustomerAccount.setGivenName("Johnn"); //make small change

			assertEquals("Johnn", TestCustomerAccount.getGivenName(), "Expect true");
		} catch (Exception e) {
			fail("Exception thrown in constructor"); // fails the test if the constructor throws an exception
		}
	}

	@Test
	@DisplayName("3. Test BankDatabaseNew Constructor")
	void BankDatabaseNew_SuccessfullyCreated_Constructor() throws Exception {
		ArrayList<CustomerAccount> AccountArraylist = new ArrayList<>();
		AccountArraylist.add(TestCustomerAccount); // create arraylist & add 1 customer account into it
		AccountArraylist.add(TestCustomerAccount2);

		BankDatabaseNew BankDatabaseConstructorTest = new BankDatabaseNew(AccountArraylist); //add to constructor
		assertEquals(2, BankDatabaseConstructorTest.size(), "Expect 1");
 	}



}
