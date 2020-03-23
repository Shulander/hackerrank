package us.vicentini.hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class TwoTwoTest extends BaseSystemStreamOverride {
    @Test
    void testCase01() {
        InputStream inputStream = getResourceAsStream("TwoTwo_01_input.txt");
        InputStream expectedStream = getResourceAsStream("TwoTwo_01_output.txt");
        provideInput(inputStream);

        TwoTwo.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void testCase02() {
        InputStream inputStream = getResourceAsStream("TwoTwo_02_input.txt");
        InputStream expectedStream = getResourceAsStream("TwoTwo_02_output.txt");
        provideInput(inputStream);

        TwoTwo.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void testCase17() {
        InputStream inputStream = getResourceAsStream("TwoTwo_17_input.txt");
        InputStream expectedStream = getResourceAsStream("TwoTwo_17_output.txt");
        provideInput(inputStream);

        TwoTwo.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
