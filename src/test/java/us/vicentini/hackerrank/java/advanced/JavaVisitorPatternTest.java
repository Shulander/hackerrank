package us.vicentini.hackerrank.java.advanced;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaVisitorPatternTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaVisitorPattern_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaVisitorPattern_01_output.txt");
        provideInput(inputStream);

        JavaVisitorPattern.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("JavaVisitorPattern_02_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaVisitorPattern_02_output.txt");
        provideInput(inputStream);

        JavaVisitorPattern.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
