package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class AppleAndOrangeTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("AppleAndOrange_01_input.txt");
        InputStream expectedStream = getResourceAsStream("AppleAndOrange_01_output.txt");
        provideInput(inputStream);

        AppleAndOrange.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
