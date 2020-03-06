package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class Java1DArrayTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("Java1DArray_01_input.txt");
        InputStream expectedStream = getResourceAsStream("Java1DArray_01_output.txt");
        provideInput(inputStream);

        Java1DArray.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
