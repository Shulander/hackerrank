package us.vicentini.hackerrank.skillsverification.javabasics;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest extends BaseSystemStreamOverride {

    @Test
    void shouldTestFizzBuzzWithOutput() {
        restoreSystemInputOutput();
        String actual = Result.printFizzBuzz(9);
        assertEquals("Fizz", actual);
        actual = Result.printFizzBuzz(10);
        assertEquals("Buzz", actual);
        actual = Result.printFizzBuzz(15);
        assertEquals("FizzBuzz", actual);
    }


    @Test
    public void testCase01() throws IOException {
        InputStream inputStream = getResourceAsStream("FizzBuzz_01_input.txt");
        InputStream expectedStream = getResourceAsStream("FizzBuzz_01_output.txt");
        provideInput(inputStream);

        FizzBuzz.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
