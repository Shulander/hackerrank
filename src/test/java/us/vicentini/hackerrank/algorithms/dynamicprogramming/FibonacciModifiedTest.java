package us.vicentini.hackerrank.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciModifiedTest extends BaseSystemStreamOverride {

    @Test
    void shouldTestFibonacciModifiedWithOutput() {
        restoreSystemInputOutput();
        BigInteger actual = FibonacciModified.fibonacciModified(0, 1, 5);
        assertEquals(BigInteger.valueOf(5), actual);

        actual = FibonacciModified.fibonacciModified(0, 1, 10);
        BigInteger expected = new BigInteger("84266613096281243382112");
        assertEquals(expected, actual);
    }


    @Test
    public void testCase01() {
        String input = "0 1 5";
        String expectedOutput = "5";

        provideInput(input);

        FibonacciModified.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "0 1 10";
        String expectedOutput = "84266613096281243382112";

        provideInput(input);

        FibonacciModified.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
