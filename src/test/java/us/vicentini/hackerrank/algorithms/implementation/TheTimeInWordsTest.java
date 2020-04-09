package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

class TheTimeInWordsTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        String input = "5\n47";
        provideInput(input);
        String expectedOutput = "thirteen minutes to six";

        TheTimeInWords.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase02() {
        String input = "3\n00";
        provideInput(input);
        String expectedOutput = "three o' clock";

        TheTimeInWords.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase03() {
        String input = "7\n15";
        provideInput(input);
        String expectedOutput = "quarter past seven";

        TheTimeInWords.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }


    @Test
    public void testCase04() {
        String input = "12\n45";
        provideInput(input);
        String expectedOutput = "quarter to one";

        TheTimeInWords.main(new String[0]);

        assertExpectedOutput(expectedOutput);
    }

}
