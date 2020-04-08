package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

class DesignerPdfViewerTest extends BaseSystemStreamOverride {
    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("DesignerPdfViewer_01_input.txt");
        InputStream expectedStream = getResourceAsStream("DesignerPdfViewer_01_output.txt");
        provideInput(inputStream);

        DesignerPdfViewer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("DesignerPdfViewer_02_input.txt");
        InputStream expectedStream = getResourceAsStream("DesignerPdfViewer_02_output.txt");
        provideInput(inputStream);

        DesignerPdfViewer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
