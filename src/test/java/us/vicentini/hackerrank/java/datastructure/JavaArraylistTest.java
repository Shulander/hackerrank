package us.vicentini.hackerrank.java.datastructure;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaArraylistTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaArraylist_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaArraylist_01_output.txt");
        provideInput(inputStream);

        JavaArraylist.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
