package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class FormingMagicSquareTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("FormingMagicSquare_01_input.txt");
        InputStream expectedStream = getResourceAsStream("FormingMagicSquare_01_output.txt");
        provideInput(inputStream);

        FormingMagicSquare.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("FormingMagicSquare_02_input.txt");
        InputStream expectedStream = getResourceAsStream("FormingMagicSquare_02_output.txt");
        provideInput(inputStream);

        FormingMagicSquare.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("FormingMagicSquare_03_input.txt");
        InputStream expectedStream = getResourceAsStream("FormingMagicSquare_03_output.txt");
        provideInput(inputStream);

        FormingMagicSquare.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}