package us.vicentini.hackerrank.java.ooprogramming;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaMethodOverriding2Test extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream expectedStream = getResourceAsStream("JavaMethodOverriding2_01_output.txt");

        JavaMethodOverriding2.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
