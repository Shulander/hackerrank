package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaBitSetTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaBitSet_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaBitSet_01_output.txt");
        provideInput(inputStream);

        JavaBitSet.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
