package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class ViralAdvertisingTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String input = "3";
        String expectedOutput = "9";

        provideInput(input);

        ViralAdvertising.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "5";
        String expectedOutput = "24";

        provideInput(input);

        ViralAdvertising.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "6";
        String expectedOutput = "37";

        provideInput(input);

        ViralAdvertising.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
