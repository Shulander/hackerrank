package us.vicentini.hackerrank.algorithms;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class CavityMapTest extends BaseSystemStreamOverride {

    @Test
    void testCase01() throws Exception {
        InputStream inputStream = getResourceAsStream("CavityMap_01_input.txt");
        InputStream expectedStream = getResourceAsStream("CavityMap_01_output.txt");
        provideInput(inputStream);

        CavityMap.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
