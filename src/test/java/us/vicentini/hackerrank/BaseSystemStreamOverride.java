package us.vicentini.hackerrank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseSystemStreamOverride {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;


    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }


    protected void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }


    protected void provideInput(InputStream data) {
        System.setIn(data);
    }


    protected String getOutput() {
        return testOut.toString();
    }


    protected InputStream getOutputAsInputStream() {
        return new ByteArrayInputStream(testOut.toByteArray());
    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    protected void assertInputStreams(InputStream expectedStream, InputStream actualStream) {
        Scanner expected = new Scanner(expectedStream);
        Scanner actual = new Scanner(actualStream);
        int line = 1;
        while (expected.hasNext() && actual.hasNext()) {
            String expectedLine = expected.nextLine();
            String actualLine = actual.nextLine();
            assertEquals(expectedLine, actualLine, "Line '" + (line++) + "' doesn't match!");
        }
        assertEquals(expected.hasNext(), actual.hasNext());
    }


    protected void assertExpectedOutput(String expectedOutput) {
        InputStream expectedStream = new ByteArrayInputStream(expectedOutput.getBytes());
        InputStream actualStream = getOutputAsInputStream();
        assertInputStreams(expectedStream, actualStream);
    }


    protected InputStream getResourceAsStream(String s) {
        return getClass().getResourceAsStream(s);
    }
}
