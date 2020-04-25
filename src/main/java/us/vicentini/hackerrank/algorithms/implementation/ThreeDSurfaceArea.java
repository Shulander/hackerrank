package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ThreeDSurfaceArea {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] a) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result += calculateArea(i, j, a);
            }
        }

        return result;
    }


    private static int calculateArea(int i, int j, int[][] a) {
        int result = 0;
        int h = getHeight(i, j, a);
        if (h > 0) {
            result += 2;
        }
        int h1 = getHeight(i - 1, j, a);
        result += h > h1 ? h - h1 : 0;
        int h2 = getHeight(i + 1, j, a);
        result += h > h2 ? h - h2 : 0;
        int h3 = getHeight(i, j - 1, a);
        result += h > h3 ? h - h3 : 0;
        int h4 = getHeight(i, j + 1, a);
        result += h > h4 ? h - h4 : 0;
        return result;
    }


    private static int getHeight(int i, int j, int[][] a) {
        try {
            return a[i][j];
        } catch (Exception e) {
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);
        System.out.println(result);

        scanner.close();
    }
}
