package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class DivisibleSumPairsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        String input = "6 5\n" +
                       "1 2 3 4 5 6";
        String expectedOutput = "3";

        provideInput(input);

        DivisibleSumPairs.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "6 3\n" +
                       "1 3 2 6 1 2";
        String expectedOutput = "5";

        provideInput(input);

        DivisibleSumPairs.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
