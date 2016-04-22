package com.hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * 
 * @author Shulander
 */
public class SherlockandAnagrams {

    private final String input;

    private SherlockandAnagrams(String input) {
        this.input = input;
    }

    public int solve() {
        return solveImpl(1);
    }

    private int solveImpl(int size) {
        int returnValue = 0;
        if (size > input.length()) {
            return returnValue;
        }
        for (int i = 0; i + size < input.length(); i++) {
            String a = sorted(input.substring(i, i+size));

            for (int j = input.length() - size; j > i; j--) {
                String b = sorted(input.substring(j, j + size));
                if (a.equals(b)) {
//                    System.out.println("{[" + i + "," + (i + size-1) + "][" + j + "," + (j + size-1) + "]}");
                    returnValue++;
                }
            }
        }

        returnValue += solveImpl(size + 1);
        return returnValue;
    }

    private String sorted(String substring) {
        char[] array = substring.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nTests = in.nextInt();
        while (nTests-- > 0) {
            String input = in.next();
            SherlockandAnagrams anagram = new SherlockandAnagrams(input);
            int solution = anagram.solve();
            System.out.println(solution);
        }
    }
}
