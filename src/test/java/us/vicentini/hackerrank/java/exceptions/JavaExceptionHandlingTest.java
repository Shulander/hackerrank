package us.vicentini.hackerrank.java.exceptions;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaExceptionHandlingTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaExceptionHandling_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaExceptionHandling_01_output.txt");
        provideInput(inputStream);

        JavaExceptionHandling.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("JavaExceptionHandling_02_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaExceptionHandling_02_output.txt");
        provideInput(inputStream);

        JavaExceptionHandling.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
