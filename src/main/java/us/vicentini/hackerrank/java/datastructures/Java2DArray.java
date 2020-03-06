package us.vicentini.hackerrank.java.datastructures;

import java.util.Scanner;

public class Java2DArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        int largerSum = findHiherHourglassSum(arr);
        System.out.println(largerSum);
    }


    private static int findHiherHourglassSum(int[][] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                int newSum = computeSum(i, j, arr);
                result = Math.max(newSum, result);
            }
        }
        return result;
    }


    private static int computeSum(int i, int j, int[][] arr) {
        int sum = arr[i - 1][j - 1];
        sum += arr[i - 1][j];
        sum += arr[i - 1][j + 1];
        sum += arr[i][j];
        sum += arr[i + 1][j - 1];
        sum += arr[i + 1][j];
        sum += arr[i + 1][j + 1];
        return sum;
    }
}
