package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaGenericsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream expectedStream = getResourceAsStream("JavaGenerics_01_output.txt");

        JavaGenerics.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
