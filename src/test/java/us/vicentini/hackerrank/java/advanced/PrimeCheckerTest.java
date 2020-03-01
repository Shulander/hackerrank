package us.vicentini.hackerrank.java.advanced;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeCheckerTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("PrimeCheckerTest_01_input.txt");
        InputStream expectedStream = getResourceAsStream("PrimeCheckerTest_01_output.txt");
        provideInput(inputStream);

        PrimeChecker.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
