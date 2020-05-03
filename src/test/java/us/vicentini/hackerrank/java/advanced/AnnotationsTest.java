package us.vicentini.hackerrank.java.advanced;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class AnnotationsTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("Annotations_01_input.txt");
        InputStream expectedStream = getResourceAsStream("Annotations_01_output.txt");
        provideInput(inputStream);

        Annotations.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
