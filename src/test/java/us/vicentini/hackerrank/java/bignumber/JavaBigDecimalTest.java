package us.vicentini.hackerrank.java.bignumber;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaBigDecimalTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaBigDecimal_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaBigDecimal_01_output.txt");
        provideInput(inputStream);

        JavaBigDecimal.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
