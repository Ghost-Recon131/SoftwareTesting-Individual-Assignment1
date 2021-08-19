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

class BankDatabaseNewTestSortingS3843790 {
	CustomerAccount TestAccount1; // class variables for storing test data
	CustomerAccount TestAccount2;
	CustomerAccount TestAccount3;
	CustomerAccount TestAccount4;
	CustomerAccount TestAccount5;
	CustomerAccount TestAccount6;
	CustomerAccount TestAccount7;
	CustomerAccount TestAccount8;
	CustomerAccount TestAccount9;
	CustomerAccount TestAccount10;
	CustomerAccount TestAccount11;
	CustomerAccount TestAccount12;
	CustomerAccount TestAccount13;
	CustomerAccount TestAccount14;
	CustomerAccount TestAccount15;
	CustomerAccount TestAccount16;
	CustomerAccount TestAccount17;
	CustomerAccount TestAccount18;

	void SetUpTestDataSet1() throws Exception{
		TestAccount1 = new CustomerAccount(100, 6296, 2000, 4000, "Galleu", "Rem", 205486);
		TestAccount2 = new CustomerAccount(1100, 7172, 6000, 12000, "Ogiwara", "Sayu", 732817);
		TestAccount3 = new CustomerAccount(1010, 7478, 5000, 10000, "Tachibana", "Taki", 664409);
		TestAccount4 = new CustomerAccount(1, 2512, 500, 1000, "Satou", "Kazuma", 920178);
		TestAccount5 = new CustomerAccount(111, 1772, 3500, 7000, "Amano", "Hina", 335368);
		TestAccount6 = new CustomerAccount(110, 9176, 3000, 6000, "Manaka", "Nemu", 974680);
		TestAccount7 = new CustomerAccount(101, 9275, 2500, 5000, "Yuuki", "Asuna", 304514);
		TestAccount8 = new CustomerAccount(1011, 9716, 5500, 11000, "Tokisaki", "Kurumi", 151915);
		TestAccount9 = new CustomerAccount(1001, 1121, 4500, 9000, "Fibel", "Sistine", 706129);
		TestAccount10 = new CustomerAccount(11, 5789, 1500, 3000, "Tachibana", "Kanade", 244650);
		TestAccount11 = new CustomerAccount(1000, 8973, 4000, 8000, "Shiota", "Nagisa", 435114);
		TestAccount12 = new CustomerAccount(10, 5678, 1000, 2000, "Miyazono", "Kaori", 123789);
	}

	void SetUpTestDataSet2() throws Exception{
		TestAccount13 = new CustomerAccount(1101, 7056, 1500, 3000, "Gura", "Gwar", 244650); // Same BSB and Balance as TestAccount 10
		TestAccount14 = new CustomerAccount(1111, 6602, 100000, 100000, "Ogiwara", "Issa", 732817); // Same family name & BSB as TestAccount2
		TestAccount15 = new CustomerAccount(10000, 7917, 6500, 13000, "Tachibana", "Mitsuha", 728824); // Same family name as TestAccount3
		TestAccount16 = new CustomerAccount(10001, 4557, 5500, 11000, "Tokisaki", "Shido", 151915);; // Same Balance, BSB and family name as TestAccount 8
		TestAccount17 = new CustomerAccount(10010, 1772, 3500, 7000, "Tempest", "Rimuru", 335368); // Same Balance as TestAccount5
		TestAccount18 = new CustomerAccount(10100, 9176, 7000, 14000, "Bloodfallen", "Shalltear", 974680); // Same BSB as TestAccount 12
	}

	@AfterEach
	void tearDown() throws Exception {
		TestAccount1 = null;
		TestAccount2 = null;
		TestAccount3 = null;
		TestAccount4 = null;
		TestAccount5 = null;
		TestAccount6 = null;
		TestAccount7 = null;
		TestAccount8 = null;
		TestAccount9 = null;
		TestAccount10 = null;
		TestAccount11 = null;
		TestAccount12 = null;
		TestAccount13 = null;
		TestAccount14 = null;
		TestAccount15 = null;
		TestAccount16 = null;
		TestAccount17 = null;
		TestAccount18 = null;
	}

	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest
	@Test
	@DisplayName("1. Matching manually sorted Arraylist to arraylist sorted by sortByTotalBalance")
	void sortByTotalBalance_CorrectlySorts_RunOnValidAccounts() throws Exception {
		BankDatabaseNew BankDatabaseTest = new BankDatabaseNew();
		SetUpTestDataSet1();
		BankDatabaseTest.add(TestAccount1); // add the test accounts to BankDatabase
		BankDatabaseTest.add(TestAccount2);
		BankDatabaseTest.add(TestAccount3);
		BankDatabaseTest.add(TestAccount4);
		BankDatabaseTest.add(TestAccount5);
		BankDatabaseTest.add(TestAccount6);
		BankDatabaseTest.add(TestAccount7);
		BankDatabaseTest.add(TestAccount8);
		BankDatabaseTest.add(TestAccount9);
		BankDatabaseTest.add(TestAccount10);
		BankDatabaseTest.add(TestAccount11);
		BankDatabaseTest.add(TestAccount12);
		BankDatabaseTest.sortByTotalBalance();

		//create arraylist where we manually sort the accounts then we will match against the arraylist sorted by the program
		ArrayList<CustomerAccount> ManuallySortedByTotalBalance = new ArrayList<>();
		ManuallySortedByTotalBalance.add(TestAccount4);
		ManuallySortedByTotalBalance.add(TestAccount12);
		ManuallySortedByTotalBalance.add(TestAccount10);
		ManuallySortedByTotalBalance.add(TestAccount1);
		ManuallySortedByTotalBalance.add(TestAccount7);
		ManuallySortedByTotalBalance.add(TestAccount6);
		ManuallySortedByTotalBalance.add(TestAccount5);
		ManuallySortedByTotalBalance.add(TestAccount11);
		ManuallySortedByTotalBalance.add(TestAccount9);
		ManuallySortedByTotalBalance.add(TestAccount3);
		ManuallySortedByTotalBalance.add(TestAccount8);
		ManuallySortedByTotalBalance.add(TestAccount2);

		assertEquals(ManuallySortedByTotalBalance, BankDatabaseTest.export(), "Expect equals");
	}

	@Test
	@DisplayName("2. Matching manually sorted Arraylist to arraylist sorted by sortByBSB")
	void sortByBSB_CorrectlySorts_RunOnValidAccounts() throws Exception {
		BankDatabaseNew BankDatabaseTest = new BankDatabaseNew();
		SetUpTestDataSet1();
		BankDatabaseTest.add(TestAccount1);
		BankDatabaseTest.add(TestAccount2);
		BankDatabaseTest.add(TestAccount3);
		BankDatabaseTest.add(TestAccount4);
		BankDatabaseTest.add(TestAccount5);
		BankDatabaseTest.add(TestAccount6);
		BankDatabaseTest.add(TestAccount7);
		BankDatabaseTest.add(TestAccount8);
		BankDatabaseTest.add(TestAccount9);
		BankDatabaseTest.add(TestAccount10);
		BankDatabaseTest.add(TestAccount11);
		BankDatabaseTest.add(TestAccount12);
		BankDatabaseTest.sortByBSB();

		ArrayList<CustomerAccount> ManuallySortedByBSB = new ArrayList<>();
		ManuallySortedByBSB.add(TestAccount12);
		ManuallySortedByBSB.add(TestAccount8);
		ManuallySortedByBSB.add(TestAccount1);
		ManuallySortedByBSB.add(TestAccount10);
		ManuallySortedByBSB.add(TestAccount7);
		ManuallySortedByBSB.add(TestAccount5);
		ManuallySortedByBSB.add(TestAccount11);
		ManuallySortedByBSB.add(TestAccount3);
		ManuallySortedByBSB.add(TestAccount9);
		ManuallySortedByBSB.add(TestAccount2);
		ManuallySortedByBSB.add(TestAccount4);
		ManuallySortedByBSB.add(TestAccount6);

		assertEquals(ManuallySortedByBSB, BankDatabaseTest.export(), "Expect equals");
	}

	@Test
	@DisplayName("3. Matching manually sorted Arraylist to arraylist sorted by sortName")
	void sortName_CorrectlySorts_RunOnValidAccounts() throws Exception {
		BankDatabaseNew BankDatabaseTest = new BankDatabaseNew();
		SetUpTestDataSet1();
		BankDatabaseTest.add(TestAccount1);
		BankDatabaseTest.add(TestAccount2);
		BankDatabaseTest.add(TestAccount3);
		BankDatabaseTest.add(TestAccount4);
		BankDatabaseTest.add(TestAccount5);
		BankDatabaseTest.add(TestAccount6);
		BankDatabaseTest.add(TestAccount7);
		BankDatabaseTest.add(TestAccount8);
		BankDatabaseTest.add(TestAccount9);
		BankDatabaseTest.add(TestAccount10);
		BankDatabaseTest.add(TestAccount11);
		BankDatabaseTest.add(TestAccount12);
		BankDatabaseTest.sortByName();

		ArrayList<CustomerAccount> ManuallySortedByName = new ArrayList<>();
		ManuallySortedByName.add(TestAccount5);
		ManuallySortedByName.add(TestAccount9);
		ManuallySortedByName.add(TestAccount1);
		ManuallySortedByName.add(TestAccount6);
		ManuallySortedByName.add(TestAccount12);
		ManuallySortedByName.add(TestAccount2);
		ManuallySortedByName.add(TestAccount4);
		ManuallySortedByName.add(TestAccount11);
		ManuallySortedByName.add(TestAccount10);
		ManuallySortedByName.add(TestAccount3);
		ManuallySortedByName.add(TestAccount8);
		ManuallySortedByName.add(TestAccount7);

		assertEquals(ManuallySortedByName, BankDatabaseTest.export(), "Expect equals");
	}

	// Repeating to ensure the behaviour of being ordered after the 'original' remains consistent
	@RepeatedTest(3)
	@DisplayName("4. Matching manually sorted Arraylist to arraylist sorted by sortByTotalBalance with dataset 2")
	void sortByTotalBalance_CorrectlySorts_SomeAccountsWithBalance() throws Exception {
		BankDatabaseNew BankDatabaseTest = new BankDatabaseNew();
		SetUpTestDataSet1();
		SetUpTestDataSet2();
		BankDatabaseTest.add(TestAccount1); // add the test accounts to BankDatabase
		BankDatabaseTest.add(TestAccount2);
		BankDatabaseTest.add(TestAccount3);
		BankDatabaseTest.add(TestAccount4);
		BankDatabaseTest.add(TestAccount5);
		BankDatabaseTest.add(TestAccount6);
		BankDatabaseTest.add(TestAccount7);
		BankDatabaseTest.add(TestAccount8);
		BankDatabaseTest.add(TestAccount9);
		BankDatabaseTest.add(TestAccount10);
		BankDatabaseTest.add(TestAccount11);
		BankDatabaseTest.add(TestAccount12);
		BankDatabaseTest.add(TestAccount13); // same as 10
		BankDatabaseTest.add(TestAccount16); // same as 8
		BankDatabaseTest.add(TestAccount17); // same as 5
		BankDatabaseTest.sortByTotalBalance();

		//create arraylist where we manually sort the accounts then we will match against the arraylist sorted by the program
		ArrayList<CustomerAccount> ManuallySortedByTotalBalance = new ArrayList<>();
		ManuallySortedByTotalBalance.add(TestAccount4);
		ManuallySortedByTotalBalance.add(TestAccount12);
		ManuallySortedByTotalBalance.add(TestAccount10);
		ManuallySortedByTotalBalance.add(TestAccount13); // same as 10
		ManuallySortedByTotalBalance.add(TestAccount1);
		ManuallySortedByTotalBalance.add(TestAccount7);
		ManuallySortedByTotalBalance.add(TestAccount6);
		ManuallySortedByTotalBalance.add(TestAccount5);
		ManuallySortedByTotalBalance.add(TestAccount17); // same as 5
		ManuallySortedByTotalBalance.add(TestAccount11);
		ManuallySortedByTotalBalance.add(TestAccount9);
		ManuallySortedByTotalBalance.add(TestAccount3);
		ManuallySortedByTotalBalance.add(TestAccount8);
		ManuallySortedByTotalBalance.add(TestAccount16); // same as 8
		ManuallySortedByTotalBalance.add(TestAccount2);

		assertEquals(ManuallySortedByTotalBalance, BankDatabaseTest.export(), "Expect equals, accounts with same details will come after the 'original' since they are added later");
	}

}
