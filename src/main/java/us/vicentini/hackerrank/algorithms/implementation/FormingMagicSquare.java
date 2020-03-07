package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class FormingMagicSquare {

    private static final int[][] magic1 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
    private static final int[][] magic2 = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
    private static final int[][] magic3 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
    private static final int[][] magic4 = {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
    private static final int[][] magic5 = {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
    private static final int[][] magic6 = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
    private static final int[][] magic7 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
    private static final int[][] magic8 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int result = calculateDifference(s, magic1);
        result = Math.min(result, calculateDifference(s, magic2));
        result = Math.min(result, calculateDifference(s, magic3));
        result = Math.min(result, calculateDifference(s, magic4));
        result = Math.min(result, calculateDifference(s, magic5));
        result = Math.min(result, calculateDifference(s, magic6));
        result = Math.min(result, calculateDifference(s, magic7));
        result = Math.min(result, calculateDifference(s, magic8));
        return result;
    }


    private static int calculateDifference(int[][] s, int[][] magic) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += Math.abs(s[i][j] - magic[i][j]);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);

        scanner.close();
    }
}
