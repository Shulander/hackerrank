package us.vicentini.hackerrank.challenge;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
 *
 * Input 7 0 0 1 0 0 1 0
 *
 * Output 4
 *
 * @author Shulander
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        System.out.println(findJumps(c, 0));
    }

    private static int findJumps(int[] c, int i) {
        if (i == c.length - 1) {
            return 0;
        }
        if (i >= c.length || c[i] == 1) {
            return -1;
        }

        int tmp = findJumps(c, i + 2);
        if (tmp == -1) {
            tmp = findJumps(c, i + 1);
        }

        if (tmp == -1) {
            return tmp;
        } else {
            return tmp + 1;
        }
    }
}
