package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class JavaStringIntroductionTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String expectedOutput = "9" + "\n" +
                                "No" + "\n" +
                                "Hello Java";


        String input = "hello\n" +
                       "java";
        provideInput(input);

        InputStream expectedStream = new ByteArrayInputStream(expectedOutput.getBytes());

        JavaStringIntroduction.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
