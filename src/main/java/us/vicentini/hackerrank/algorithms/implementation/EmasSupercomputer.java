package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmasSupercomputer {

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        List<Cell> startingCells = createGrowCell(grid);

        Collections.sort(startingCells);


        return bestTwoPluses(startingCells, 1);
    }


    private static int bestTwoPluses(List<Cell> startingCells, int best) {
        if (startingCells.size() <= 1) {
            return best;
        }
        Cell cell = startingCells.remove(0);
        best = getBest(startingCells, best, cell);
        int newBest = bestTwoPluses(startingCells, best);
        if (newBest > best) {
            best = newBest;
        }
        startingCells.add(0, cell);

        return best;
    }


    private static int getBest(List<Cell> startingCells, int best, Cell cell) {
        for (Cell cellB : startingCells) {
            if (Cell.calculateFor(cell.getSize(), cellB.getSize()) <= best) {
                return best;
            }
            int newBest = cell.computeBest(cellB);
            if (newBest > best) {
                best = newBest;
            }
        }
        return best;
    }


    private static List<Cell> createGrowCell(String[] grid) {
        List<Cell> cells = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == 'G') {
                    Cell e = new Cell(i, j, grid);
                    e.grow();
                    cells.add(e);
                }
            }

        }
        return cells;
    }


    public static class Cell implements Comparable<Cell> {
        private final String[] grid;
        private final int line;
        private final int column;
        private int size = 0;


        public int getSize() {
            return size;
        }


        public Cell(int line, int column, String[] grid) {
            this.line = line;
            this.column = column;
            this.grid = grid;
        }


        public Cell(int line, int column, int size) {
            this.line = line;
            this.column = column;
            this.size = size;
            grid = new String[0];
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return line == cell.line &&
                   column == cell.column &&
                   size == cell.size;
        }


        @Override
        public int hashCode() {
            return Objects.hash(line, column, size);
        }


        @Override
        public int compareTo(Cell o) {
            if (this.equals(o)) {
                return 0;
            }
            return o.size - this.size;
        }


        public void grow() {
            while (canGrow(size + 1)) {
                size++;
            }
        }


        @Override
        public String toString() {
            return "Cell{" +
                   "line=" + line +
                   ", column=" + column +
                   ", size=" + size +
                   '}';
        }


        private boolean canGrow(int size) {
            try {
                return (grid[line].charAt(column + size) == 'G')
                       && (grid[line].charAt(column - size) == 'G')
                       && (grid[line + size].charAt(column) == 'G')
                       && (grid[line - size].charAt(column) == 'G');
            } catch (Exception ex) {
                return false;
            }
        }


        public int computeBest(Cell cellB) {
            if (!isConflict(cellB)) {
                return calculateFor(size, cellB.size);
            }

            Cell clone1 = new Cell(line, column, grid);
            Cell clone2 = new Cell(cellB.line, cellB.column, grid);
            for (int i = 1; i < Math.max(size, cellB.size); i++) {
                if (clone1.canGrow(i)) {
                    clone1.size++;
                    if (clone1.isConflict(clone2)) {
                        clone1.size--;
                    }
                }
                if (clone2.canGrow(i)) {
                    clone2.size++;
                    if (clone2.isConflict(clone1)) {
                        clone2.size--;
                    }
                }
            }
            return calculateFor(clone1.size, clone2.size);

        }


        public boolean isConflict(Cell cellB) {
            int lDistance = Math.abs(line - cellB.line);
            int cDistance = Math.abs(column - cellB.column);
            if (lDistance == 0) {
                return cDistance <= size + cellB.size;
            } else if (cDistance == 0) {
                return lDistance <= size + cellB.size;
            }
            int maxD = Math.max(lDistance, cDistance);
            int minD = Math.min(lDistance, cDistance);
            int maxSize = Math.max(this.size, cellB.size);
            int minSize = Math.min(this.size, cellB.size);
            if (maxD > maxSize) {
                return false;
            }
            return minD <= minSize;
        }


        public static int calculateFor(int size, int size1) {
            int a = 1 + size * 4;
            int b = 1 + size1 * 4;
            return a * b;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        System.out.println(result);

        scanner.close();
    }
}
