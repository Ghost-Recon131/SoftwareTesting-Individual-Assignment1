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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	void SetUpTestData() throws Exception{
		TestAccount1 = new CustomerAccount(1, 2512, 500, 1000, "Satou", "Kazuma", 920178);
		TestAccount2 = new CustomerAccount(10, 5678, 1000, 2000, "Miyazono", "Kaori", 123789);
		TestAccount3 = new CustomerAccount(11, 5789, 1500, 3000, "Tachibana", "Kanade", 244650);
		TestAccount4 = new CustomerAccount(100, 6296, 2000, 4000, "Galleu", "Rem", 205486);
		TestAccount5 = new CustomerAccount(101, 9275, 2500, 5000, "Yuuki", "Asuna", 304514);
		TestAccount6 = new CustomerAccount(110, 9176, 3000, 6000, "Manaka", "Nemu", 974680);
		TestAccount7 = new CustomerAccount(111, 1772, 3500, 7000, "Amano", "Hina", 335368);
		TestAccount8 = new CustomerAccount(1000, 8973, 4000, 8000, "Shiota", "Nagisa", 435114);
		TestAccount9  = new CustomerAccount(1001, 1121, 4500, 9000, "Fibel", "Sistine", 706129);
		TestAccount10 = new CustomerAccount(1010, 7478, 5000, 10000, "Tachibana", "Taki", 664409);
		TestAccount11 = new CustomerAccount(1011, 9716, 5500, 11000, "Tokisaki", "Kurumi", 151915);
		TestAccount12 = new CustomerAccount(1100, 7172, 6000, 12000, "Ogiwara", "Sayu", 732817);
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
	}

	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
