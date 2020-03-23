package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class OrganizingContainersOfBallsTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("OrganizingContainersOfBalls_01_input.txt");
        InputStream expectedStream = getResourceAsStream("OrganizingContainersOfBalls_01_output.txt");
        provideInput(inputStream);

        OrganizingContainersOfBalls.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("OrganizingContainersOfBalls_02_input.txt");
        InputStream expectedStream = getResourceAsStream("OrganizingContainersOfBalls_02_output.txt");
        provideInput(inputStream);

        OrganizingContainersOfBalls.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
