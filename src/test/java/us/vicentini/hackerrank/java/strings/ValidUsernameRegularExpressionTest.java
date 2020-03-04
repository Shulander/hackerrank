package us.vicentini.hackerrank.java.strings;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidUsernameRegularExpressionTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("ValidUsernameRegularExpression_01_input.txt");
        InputStream expectedStream = getResourceAsStream("ValidUsernameRegularExpression_01_output.txt");
        provideInput(inputStream);

        ValidUsernameRegularExpression.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }

}
