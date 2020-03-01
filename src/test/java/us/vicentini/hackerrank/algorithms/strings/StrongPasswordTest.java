package us.vicentini.hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class StrongPasswordTest extends BaseSystemStreamOverride {

    @Test
    void testCase01() {
        InputStream inputStream = getResourceAsStream("StrongPassword_01_input.txt");
        InputStream expectedStream = getResourceAsStream("StrongPassword_01_output.txt");
        provideInput(inputStream);

        StrongPassword.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void testCase02() {
        InputStream inputStream = getResourceAsStream("StrongPassword_02_input.txt");
        InputStream expectedStream = getResourceAsStream("StrongPassword_02_output.txt");
        provideInput(inputStream);

        StrongPassword.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void testCase03() {
        InputStream inputStream = getResourceAsStream("StrongPassword_03_input.txt");
        InputStream expectedStream = getResourceAsStream("StrongPassword_03_output.txt");
        provideInput(inputStream);

        StrongPassword.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
