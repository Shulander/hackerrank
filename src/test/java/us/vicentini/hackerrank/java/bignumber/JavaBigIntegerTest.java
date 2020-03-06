package us.vicentini.hackerrank.java.bignumber;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaBigIntegerTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaBigInteger_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaBigInteger_01_output.txt");
        provideInput(inputStream);

        JavaBigInteger.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
