package us.vicentini.hackerrank.java.strings;

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = smallest;

        for (int i = 1; i <= s.length() - k; i++) {
            String substr = s.substring(i, i + k);
            if (smallest.compareTo(substr) > 0) {
                smallest = substr;
            } else if (largest.compareTo(substr) < 0) {
                largest = substr;
            }
        }


        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
