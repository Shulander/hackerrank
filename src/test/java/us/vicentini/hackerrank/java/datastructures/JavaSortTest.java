package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaSortTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaSort_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaSort_01_output.txt");
        provideInput(inputStream);

        JavaSort.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
