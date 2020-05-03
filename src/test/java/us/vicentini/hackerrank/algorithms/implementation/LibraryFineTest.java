package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class LibraryFineTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String input = "9 6 2015\n" +
                       "6 6 2015";
        String expectedOutput = "45";

        provideInput(input);

        LibraryFine.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "2 7 1014\n" +
                       "1 1 1015";
        String expectedOutput = "0";

        provideInput(input);

        LibraryFine.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "28 2 2015\n" +
                       "15 4 2015";
        String expectedOutput = "0";

        provideInput(input);

        LibraryFine.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
