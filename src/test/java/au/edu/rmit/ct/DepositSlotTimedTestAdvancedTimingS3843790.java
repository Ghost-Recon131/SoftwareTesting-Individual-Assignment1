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

class DepositSlotTimedTestAdvancedTimingS3843790 {
	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest
	@Test
	void run_ReturnsFalse_BeforeDepositSlotActivationPeriod() throws Exception {
		DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("TestDepositSlot", 10);

		assertFalse(TestDepositSlotTimed.isOpenForDeposit(), "Expect false after period of activation");
	}

	@Test
	void run_ReturnsFalse_AfterDepositSlotActivationPeriod() throws Exception {
		DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("TestDepositSlot", 10);
		TestDepositSlotTimed.run();

		assertFalse(TestDepositSlotTimed.isOpenForDeposit(), "Expect false after period of activation");
	}

	@Test
	void run_ReturnsTrue_DuringDepositSlotActivationPeriod() throws Exception {
		DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("TestDepositSlot", 10);

		new Thread(() -> {
			TestDepositSlotTimed.run();
			assertTrue(TestDepositSlotTimed.isOpenForDeposit(), "Expect true");
		});
	}

}
