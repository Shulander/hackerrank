package us.vicentini.hackerrank.java.ooprogramming;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaInstanceofKeywordTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaInstanceofKeyword_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaInstanceofKeyword_01_output.txt");
        provideInput(inputStream);

        JavaInstanceofKeyword.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }

}
