package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaSubstringComparisonsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaSubstringComparisons_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaSubstringComparisons_01_output.txt");
        provideInput(inputStream);

        JavaSubstringComparisons.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
