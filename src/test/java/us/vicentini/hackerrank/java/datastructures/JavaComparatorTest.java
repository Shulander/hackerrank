package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaComparatorTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaComparator_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaComparator_01_output.txt");
        provideInput(inputStream);

        JavaComparator.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }

}
