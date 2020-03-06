package us.vicentini.hackerrank.java.ooprogramming;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaMethodOverridingTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream expectedStream = getResourceAsStream("JavaMethodOverriding_01_output.txt");

        JavaMethodOverriding.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
