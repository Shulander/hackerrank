package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeDSurfaceAreaTest extends BaseSystemStreamOverride {
    @Test
    void name() {
        restoreSystemInputOutput();
        int[][] a = {{1, 3, 4},
                     {2, 2, 3},
                     {1, 2, 4}};
        int actual = ThreeDSurfaceArea.surfaceArea(a);
        assertEquals(60, actual);
    }


    @Test
    public void testCase01() {
        String input = "3 3\n" +
                       "1 3 4\n" +
                       "2 2 3\n" +
                       "1 2 4";
        String expectedOutput = "60";

        provideInput(input);

        ThreeDSurfaceArea.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase021() {
        String input = "1 1\n" +
                       "1";
        String expectedOutput = "6";

        provideInput(input);

        ThreeDSurfaceArea.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
