package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class FlatlandSpaceStationsTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String input = "5 2\n" +
                       "0 4";
        provideInput(input);
        String expectedOutput = "2";

        FlatlandSpaceStations.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "6 6\n" +
                       "0 1 2 4 3 5";
        provideInput(input);
        String expectedOutput = "0";

        FlatlandSpaceStations.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "10 6\n" +
                       "0 1 2 4 3 5";
        provideInput(input);
        String expectedOutput = "4";

        FlatlandSpaceStations.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase04() {
        String input = "10 6\n" +
                       "4 3 5 6 7 8";
        provideInput(input);
        String expectedOutput = "3";

        FlatlandSpaceStations.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
