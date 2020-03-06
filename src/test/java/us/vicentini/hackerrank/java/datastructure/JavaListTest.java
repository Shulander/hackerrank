package us.vicentini.hackerrank.java.datastructure;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaListTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaList_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaList_01_output.txt");
        provideInput(inputStream);

        JavaList.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
