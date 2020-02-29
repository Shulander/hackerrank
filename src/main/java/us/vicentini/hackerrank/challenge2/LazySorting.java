package us.vicentini.hackerrank.challenge2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class LazySorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] value = new int[size];

        for (int i = 0; i < size; i++) {
            value[i] = in.nextInt();
        }

        System.out.println(String.format("%d.000000", solve(size, value)));
    }

    private static int solve(int size, int[] values) {
        Arrays.sort(values);
        int divisor = 1;
        int value = values[0];
        int aux = 1;
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (values[i] == value) {
                count++;
                aux *= count;
            } else {
                divisor *= aux;
                aux = 1;
                count = 1;
                value = values[i];
            }
        }
        divisor *= aux;
        int dividend = 1;
        for (int i = size; i > 0; i--) {
            dividend *= i;
        }

        return dividend / divisor;
    }
}
