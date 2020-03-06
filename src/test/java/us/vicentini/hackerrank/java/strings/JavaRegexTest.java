package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaRegexTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaRegex_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaRegex_01_output.txt");
        provideInput(inputStream);

        JavaRegex.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("JavaRegex_02_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaRegex_02_output.txt");
        provideInput(inputStream);

        JavaRegex.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
