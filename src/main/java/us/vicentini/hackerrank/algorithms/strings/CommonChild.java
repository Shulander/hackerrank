package us.vicentini.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * References
 * https://www.hackerrank.com/challenges/common-child/problem
 * https://www.hackerrank.com/challenges/common-child/topics/dynamic-programming-basics
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int size = s1.length();
        int[][] c = new int[size + 1][size + 1];
        for (int i = 0; i <= size; i++) {
            c[i][0] = 0;
            c[0][i] = 0;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    c[i + 1][j + 1] = c[i][j] + 1;
                } else {
                    c[i + 1][j + 1] = Math.max(c[i + 1][j], c[i][j + 1]);
                }
            }
        }

        return c[size][size];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(result);
        scanner.close();
    }
}
