package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaArraylistTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaArraylist_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaArraylist_01_output.txt");
        provideInput(inputStream);

        JavaArraylist.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
