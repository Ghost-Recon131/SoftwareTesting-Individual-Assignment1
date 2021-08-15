/**
*  
* Name: John Smith
* Student ID: s45045012
* Email: s45045012@student.rmit.edu.au
* 
* [OPTIONAL: add any notes here about the code]
*/

package au.edu.rmit.ct;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/*
 * Please replace S3214321 of class name with your own student number
 */

class DepositSlotTimedTestSimpleRepeatS3843790 {

	//Test naming convention used: MethodName_ExpectedBehavior_StateUnderTest
	@Nested
	class DepositSlotTimedConstructorTest{
		@Test
		@DisplayName("1. Test Default Constructor")
		void DepositSlotTimed_SuccessfullyCreated_DefaultConstructor() {
			DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("Test");

			assertFalse(TestDepositSlotTimed.isOpenForDeposit(), "Expect False");
		}

		@Test
		@DisplayName("2. Test Constructor")
		void DepositSlotTimed_SuccessfullyCreated_Constructor() throws Exception {
			DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("Test2", 3000);

			assertFalse(TestDepositSlotTimed.isOpenForDeposit(), "Expect False");
		}

		@Test
		@DisplayName("3. Test CustomWaitTime is too high")
		void DepositSlotTimed_ThrowsException_CustomWaitTimeIsTooHigh() throws Exception {
			assertThrows(Exception.class, () -> new DepositSlotTimed("Test2", 5001), "Expect Exception");
		}

		@Test
		@DisplayName("4. Test CustomWaitTime is too low")
		void DepositSlotTimed_ThrowsException_CustomWaitTimeIsNegative() throws Exception {
			assertThrows(Exception.class, () -> new DepositSlotTimed("Test2", -100), "Expect Exception");
		}
	}

	@RepeatedTest(10)
	@DisplayName("5. Attempting to locate error margin")
	void checkTimer_HalfOfTestsWillFail_AttemptingToLocateErrorMargin() throws Exception {
		DepositSlotTimed TestDepositSlotTimed = new DepositSlotTimed("Test2", 4999);
		assertTimeout(ofMillis(4999), () -> {
			TestDepositSlotTimed.checkTimer();
		});
	}


}
