package us.vicentini.hackerrank.algorithms.datastructures.trees;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class PostorderTraversalTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        String input = "6\n" +
                       "1 2 5 3 6 4";
        String expectedOutput = "4 3 6 5 2 1 ";

        provideInput(input);

        PostorderTraversal.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "15\n" +
                       "1 14 3 7 4 5 15 6 13 10 11 2 12 8 9";
        String expectedOutput = "2 6 5 4 9 8 12 11 10 13 7 3 15 14 1 ";

        provideInput(input);

        PostorderTraversal.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
