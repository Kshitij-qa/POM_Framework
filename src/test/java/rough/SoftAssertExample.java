package rough;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class SoftAssertExample {

    @Test
    public void testSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        int expectedValue = 10;
        int actualValue = 5 + 5;

        // Soft assert the first condition
        softAssert.assertEquals(actualValue, expectedValue, "The actual value does not match the expected value.");

        String expectedString = "Hello";
        String actualString = "Hello World";

        // Soft assert the second condition
        softAssert.assertTrue(actualString.startsWith(expectedString), "The actual string does not start with the expected string.");

        // Soft assert the third condition
        softAssert.assertFalse(actualString.contains("Goodbye"), "The actual string contains an unexpected substring.");

        // Call assertAll() to verify all soft asserts
        softAssert.assertAll();
    }
}
