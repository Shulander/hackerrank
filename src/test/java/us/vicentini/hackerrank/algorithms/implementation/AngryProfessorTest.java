package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class AngryProfessorTest extends BaseSystemStreamOverride {

    @Test
    void testCase01() {
        InputStream inputStream = getResourceAsStream("AngryProfessor_01_input.txt");
        InputStream expectedStream = getResourceAsStream("AngryProfessor_01_output.txt");
        provideInput(inputStream);

        AngryProfessor.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
