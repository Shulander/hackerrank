package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class DuplicateWordsTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("DuplicateWords_01_input.txt");
        InputStream expectedStream = getResourceAsStream("DuplicateWords_01_output.txt");
        provideInput(inputStream);

        DuplicateWords.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
