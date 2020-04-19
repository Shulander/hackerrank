package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingValleysTest extends BaseSystemStreamOverride {

    @Test
    void shouldTestCountingValleysMethodWithOutput() {
        restoreSystemInputOutput();
        int actual = CountingValleys.countingValleys(8, "UDDDUDUU");
        assertEquals(1, actual);
    }


    @Test
    public void testCase01() {
        String input = "8\n" +
                       "UDDDUDUU";
        String expectedOutput = "1";

        provideInput(input);

        CountingValleys.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "12\n" +
                       "DDUUDDUDUUUD";
        String expectedOutput = "2";

        provideInput(input);

        CountingValleys.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
