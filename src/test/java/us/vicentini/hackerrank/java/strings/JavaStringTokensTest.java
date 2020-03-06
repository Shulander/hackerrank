package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class JavaStringTokensTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaStringTokens_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaStringTokens_01_output.txt");
        provideInput(inputStream);

        JavaStringTokens.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("JavaStringTokens_02_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaStringTokens_02_output.txt");
        provideInput(inputStream);

        JavaStringTokens.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void testCase09() {
        String expectedOutput = "0";

        String input = "                        ";
        provideInput(input);

        InputStream expectedStream = new ByteArrayInputStream(expectedOutput.getBytes());

        JavaStringTokens.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
