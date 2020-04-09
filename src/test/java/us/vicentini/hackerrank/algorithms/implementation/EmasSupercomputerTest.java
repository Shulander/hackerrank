package us.vicentini.hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;
import us.vicentini.hackerrank.algorithms.implementation.EmasSupercomputer.Cell;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmasSupercomputerTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_01_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_01_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase02() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_02_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_02_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase03() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_03_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_03_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase04() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_04_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_04_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase05() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_05_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_05_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    public void testCase06() {
        InputStream inputStream = getResourceAsStream("EmasSupercomputer_06_input.txt");
        InputStream expectedStream = getResourceAsStream("EmasSupercomputer_06_output.txt");
        provideInput(inputStream);

        EmasSupercomputer.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }


    @Test
    void shouldTestSomeConflicts() {

        Cell cella = new Cell(4, 5, 4);
        Cell cellb = new Cell(4, 6, 4);
        Cell cellc = new Cell(9, 5, 4);
        Cell celld = new Cell(9, 6, 4);

        assertTrue(cella.isConflict(cellb));
        assertTrue(cella.isConflict(cellc));
        assertTrue(cellb.isConflict(cella));
        assertFalse(cellb.isConflict(cellc));
        assertTrue(cellb.isConflict(celld));
    }


    @Test
    void shouldNotConflict() {

        Cell cella = new Cell(4, 5, 4);
        Cell cellb = new Cell(7, 8, 2);

        assertFalse(cella.isConflict(cellb));
    }


    @Test
    void shouldConflict() {

        Cell cella = new Cell(4, 5, 4);
        Cell cellb = new Cell(6, 8, 2);

        assertTrue(cella.isConflict(cellb));
    }
}
