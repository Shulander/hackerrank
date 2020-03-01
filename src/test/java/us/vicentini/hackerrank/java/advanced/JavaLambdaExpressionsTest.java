package us.vicentini.hackerrank.java.advanced;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaLambdaExpressionsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() throws IOException {
        InputStream inputStream = getResourceAsStream("JavaLambdaExpressions_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaLambdaExpressions_01_output.txt");
        provideInput(inputStream);

        JavaLambdaExpressions.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
