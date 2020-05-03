package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class BeautifulTripletsTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String input = "7 3\n" +
                       "1 2 4 5 7 8 10";
        String expectedOutput = "3";

        provideInput(input);

        BeautifulTriplets.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "10 3\n" +
                       "1 6 7 7 8 10 12 13 14 19";
        String expectedOutput = "2";

        provideInput(input);

        BeautifulTriplets.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


}
