package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class JavaStringReverseTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        String expectedOutput = "Yes";

        String input = "madam";
        provideInput(input);

        InputStream expectedStream = new ByteArrayInputStream(expectedOutput.getBytes());

        JavaStringReverse.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
