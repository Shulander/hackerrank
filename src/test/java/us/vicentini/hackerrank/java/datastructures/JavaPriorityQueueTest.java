package us.vicentini.hackerrank.java.datastructures;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class JavaPriorityQueueTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("JavaPriorityQueue_01_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaPriorityQueue_01_output.txt");
        provideInput(inputStream);

        JavaPriorityQueue.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("JavaPriorityQueue_02_input.txt");
        InputStream expectedStream = getResourceAsStream("JavaPriorityQueue_02_output.txt");
        provideInput(inputStream);

        JavaPriorityQueue.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }

}
