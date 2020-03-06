package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaMapTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaMap_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaMap_01_output.txt");
        provideInput(inputStream);

        JavaMap.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
