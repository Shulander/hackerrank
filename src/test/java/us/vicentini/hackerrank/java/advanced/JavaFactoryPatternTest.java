package us.vicentini.hackerrank.java.advanced;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaFactoryPatternTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() throws IOException {
        String expectedPizzaOutput = "The factory returned class us.vicentini.hackerrank.java.advanced.Pizza\n" +
                                     "Someone ordered a Fast Food!";
        InputStream expectedStream = new ByteArrayInputStream(expectedPizzaOutput.getBytes());
        provideInput("pizza");

        JavaFactoryPattern.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }


    @Test
    public void testCase02() throws IOException {
        String expectedPizzaOutput = "The factory returned class us.vicentini.hackerrank.java.advanced.Cake\n" +
                                     "Someone ordered a Dessert!";
        InputStream expectedStream = new ByteArrayInputStream(expectedPizzaOutput.getBytes());
        provideInput("cake");

        JavaFactoryPattern.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
        assertTrue(true);
    }
}
