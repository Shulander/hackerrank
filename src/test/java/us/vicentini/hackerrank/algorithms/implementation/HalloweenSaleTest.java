package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class HalloweenSaleTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("HalloweenSale_01_input.txt");
        InputStream expectedStream = getResourceAsStream("HalloweenSale_01_output.txt");
        provideInput(inputStream);

        HalloweenSale.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("HalloweenSale_02_input.txt");
        InputStream expectedStream = getResourceAsStream("HalloweenSale_02_output.txt");
        provideInput(inputStream);

        HalloweenSale.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
