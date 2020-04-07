package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class TheBombermanGame {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        if (n == 1) {
            return grid;
        }
        int scenario = (n - 1) % 4;
        if (scenario == 0) {
            String[] newGrid = explodedBoard(grid);
            return explodedBoard(newGrid);
        } else if (scenario == 1 || scenario == 3) {
            return allCoveredBoard(grid);
        } else if (scenario == 2) {
            return explodedBoard(grid);
        }
        return new String[0];
    }


    private static String[] explodedBoard(String[] grid) {
        String[] covered = allCoveredBoard(grid);
        char[][] board = new char[covered.length][];
        for (int i = 0; i < covered.length; i++) {
            board[i] = covered[i].toCharArray();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (grid[i].charAt(j) == 'O') {
                    explode(board, i, j);
                }
            }
        }
        String[] result = new String[grid.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = new String(board[i]);
        }

        return result;
    }


    private static void explode(char[][] board, int i, int j) {
        board[i][j] = '.';
        if (i > 0) {
            board[i - 1][j] = '.';
        }
        if (i + 1 < board.length) {
            board[i + 1][j] = '.';
        }
        if (j > 0) {
            board[i][j - 1] = '.';
        }
        if (j + 1 < board[i].length) {
            board[i][j + 1] = '.';
        }
    }


    private static String[] allCoveredBoard(String[] grid) {
        String[] board = new String[grid.length];
        for (int i = 0; i < grid.length; i++) {
            board[i] = grid[i].replace('.', 'O');
        }
        return board;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }
}
