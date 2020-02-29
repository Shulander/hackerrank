package us.vicentini.hackerrank.challenge2;

import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        System.out.println((solve(x1, v1, x2, v2) ? "YES" : "NO"));

    }

    private static boolean solve(int x1, int v1, int x2, int v2) {
        int angular = v1 - v2;
        int linear = x2 - x1;

        if (angular == 0) {
            return false;
        }

        int xintersection = linear / angular;

        if (xintersection > 0) {
            int y1 = v1 * xintersection + x1;
            int y2 = v2 * xintersection + x2;
            return y1 == y2;
        } else {
            return false;
        }

    }
}
