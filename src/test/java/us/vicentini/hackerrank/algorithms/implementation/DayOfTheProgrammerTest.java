package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.IOException;

class DayOfTheProgrammerTest extends BaseSystemStreamOverride {


    @Test
    public void testCase01() throws IOException {
        String input = "2017";
        String expectedOutput = "13.09.2017";

        provideInput(input);

        DayOfTheProgrammer.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() throws IOException {
        String input = "2016";
        String expectedOutput = "12.09.2016";

        provideInput(input);

        DayOfTheProgrammer.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() throws IOException {
        String input = "1800";
        String expectedOutput = "12.09.1800";

        provideInput(input);

        DayOfTheProgrammer.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase04() throws IOException {
        String input = "1918";
        String expectedOutput = "26.09.1918";

        provideInput(input);

        DayOfTheProgrammer.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
