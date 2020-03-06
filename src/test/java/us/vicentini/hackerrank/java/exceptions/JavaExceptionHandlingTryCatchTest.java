package us.vicentini.hackerrank.java.exceptions;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class JavaExceptionHandlingTryCatchTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        provideInput("10\n3");
        InputStream expectedStream = new ByteArrayInputStream("3".getBytes());

        JavaExceptionHandlingTryCatch.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        provideInput("10\nHello");
        InputStream expectedStream = new ByteArrayInputStream("java.util.InputMismatchException".getBytes());

        JavaExceptionHandlingTryCatch.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        provideInput("10\n0");
        InputStream expectedStream = new ByteArrayInputStream("java.lang.ArithmeticException: / by zero".getBytes());

        JavaExceptionHandlingTryCatch.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase04() {
        provideInput("23.323\n0");
        InputStream expectedStream = new ByteArrayInputStream("java.util.InputMismatchException".getBytes());

        JavaExceptionHandlingTryCatch.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
