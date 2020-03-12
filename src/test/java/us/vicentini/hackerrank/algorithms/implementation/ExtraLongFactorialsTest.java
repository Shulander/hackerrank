package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class ExtraLongFactorialsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("ExtraLongFactorials_01_input.txt");
        InputStream expectedStream = getResourceAsStream("ExtraLongFactorials_01_output.txt");
        provideInput(inputStream);

        ExtraLongFactorials.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("ExtraLongFactorials_02_input.txt");
        InputStream expectedStream = getResourceAsStream("ExtraLongFactorials_02_output.txt");
        provideInput(inputStream);

        ExtraLongFactorials.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
