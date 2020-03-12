package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class QueensAttackIITest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("QueensAttackII_01_input.txt");
        InputStream expectedStream = getResourceAsStream("QueensAttackII_01_output.txt");
        provideInput(inputStream);

        QueensAttackII.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("QueensAttackII_02_input.txt");
        InputStream expectedStream = getResourceAsStream("QueensAttackII_02_output.txt");
        provideInput(inputStream);

        QueensAttackII.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("QueensAttackII_03_input.txt");
        InputStream expectedStream = getResourceAsStream("QueensAttackII_03_output.txt");
        provideInput(inputStream);

        QueensAttackII.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase04() {
        InputStream inputStream = getResourceAsStream("QueensAttackII_04_input.txt");
        InputStream expectedStream = getResourceAsStream("QueensAttackII_04_output.txt");
        provideInput(inputStream);

        QueensAttackII.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
