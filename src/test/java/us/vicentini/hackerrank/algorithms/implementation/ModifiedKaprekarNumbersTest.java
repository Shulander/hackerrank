package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModifiedKaprekarNumbersTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        assertTrue(ModifiedKaprekarNumbers.isKaprekarNumber(99));
        assertFalse(ModifiedKaprekarNumbers.isKaprekarNumber(98));
    }


    @Test
    public void testCase02() {
        String input = "1\n" +
                       "100";
        String expectedOutput = "1 9 45 55 99";

        provideInput(input);

        ModifiedKaprekarNumbers.main(new String[0]);

        assertExpectedOutput(expectedOutput);

    }


    @Test
    public void testCase03() {
        String input = "1\n" +
                       "99999";
        String expectedOutput =
                "1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999";

        provideInput(input);

        ModifiedKaprekarNumbers.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
