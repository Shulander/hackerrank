package us.vicentini.hackerrank.java.ooprogramming;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaIteratorTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaIterator_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaIterator_01_output.txt");
        provideInput(inputStream);

        JavaIterator.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
