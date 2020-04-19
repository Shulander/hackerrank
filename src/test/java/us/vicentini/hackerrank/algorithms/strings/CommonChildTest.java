package us.vicentini.hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonChildTest extends BaseSystemStreamOverride {

    @Test
    void shouldTestCommonChildMethodWithOutput() {
        restoreSystemInputOutput();
        int actual = CommonChild.commonChild("HARRY", "SALLY");
        assertEquals(2, actual);

        actual = CommonChild.commonChild("SHINCHAN", "NOHARAAA");
        assertEquals(3, actual);

        actual = CommonChild.commonChild("ABCDEF", "FBDAMN");
        assertEquals(2, actual);
    }


    @Test
    public void testCase01() {
        String input = "HARRY\n" +
                       "SALLY";
        String expectedOutput = "2";

        provideInput(input);

        CommonChild.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "SHINCHAN\n" +
                       "NOHARAAA";
        String expectedOutput = "3";

        provideInput(input);

        CommonChild.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "ABCDEF\n" +
                       "FBDAMN";
        String expectedOutput = "2";

        provideInput(input);

        CommonChild.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
