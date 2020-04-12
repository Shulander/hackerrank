package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class StrangeCounterTest extends BaseSystemStreamOverride {


    @Test
    public void testCase01() {
        String input = "4";
        String expectedOutput = "6";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "3";
        String expectedOutput = "1";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "7";
        String expectedOutput = "3";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase04() {
        String input = "15";
        String expectedOutput = "7";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase05() {
        String input = "9";
        String expectedOutput = "1";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase06() {
        String input = "21";
        String expectedOutput = "1";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase07() {
        String input = "10";
        String expectedOutput = "12";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase08() {
        String input = "22";
        String expectedOutput = "24";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase09() {
        String input = "1000000000000";
        String expectedOutput = "649267441662";

        provideInput(input);

        StrangeCounter.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
