package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class TagContentExtractorTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("TagContentExtractor_01_input.txt");
        InputStream expectedStream = getResourceAsStream("TagContentExtractor_01_output.txt");
        provideInput(inputStream);

        TagContentExtractor.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("TagContentExtractor_02_input.txt");
        InputStream expectedStream = getResourceAsStream("TagContentExtractor_02_output.txt");
        provideInput(inputStream);

        TagContentExtractor.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("TagContentExtractor_03_input.txt");
        InputStream expectedStream = getResourceAsStream("TagContentExtractor_03_output.txt");
        provideInput(inputStream);

        TagContentExtractor.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
