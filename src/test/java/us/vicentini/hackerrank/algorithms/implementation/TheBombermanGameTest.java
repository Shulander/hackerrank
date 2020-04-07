package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class TheBombermanGameTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("TheBombermanGame_01_input.txt");
        InputStream expectedStream = getResourceAsStream("TheBombermanGame_01_output.txt");
        provideInput(inputStream);

        TheBombermanGame.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("TheBombermanGame_02_input.txt");
        InputStream expectedStream = getResourceAsStream("TheBombermanGame_02_output.txt");
        provideInput(inputStream);

        TheBombermanGame.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("TheBombermanGame_03_input.txt");
        InputStream expectedStream = getResourceAsStream("TheBombermanGame_03_output.txt");
        provideInput(inputStream);

        TheBombermanGame.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
