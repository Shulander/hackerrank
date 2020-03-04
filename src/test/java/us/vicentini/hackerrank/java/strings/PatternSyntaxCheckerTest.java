package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternSyntaxCheckerTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("PatternSyntaxChecker_01_input.txt");
        InputStream expectedStream = getResourceAsStream("PatternSyntaxChecker_01_output.txt");
        provideInput(inputStream);

        PatternSyntaxChecker.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
