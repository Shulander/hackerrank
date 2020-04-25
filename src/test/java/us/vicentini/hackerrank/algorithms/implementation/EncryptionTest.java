package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class EncryptionTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        String input = "haveaniceday";
        String expectedOutput = "hae and via ecy";

        provideInput(input);

        Encryption.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "chillout";
        String expectedOutput = "clu hlt io";

        provideInput(input);

        Encryption.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "feedthedog";
        String expectedOutput = "fto ehg ee dd";

        provideInput(input);

        Encryption.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase04() {
        String input = "feedthedo";
        String expectedOutput = "fde etd eho";

        provideInput(input);

        Encryption.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }
}
