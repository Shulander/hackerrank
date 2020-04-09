package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class TheTimeInWords {

    private static final String[] WORDS = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
    };


    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        int nextHour = (h + 1) % 12;
        if (m == 0) {
            return String.format("%s o' clock", WORDS[h]);
        } else if (m == 15) {
            return String.format("quarter past %s", WORDS[h]);
        } else if (m == 30) {
            return String.format("half past %s", WORDS[h]);
        } else if (m == 45) {
            return String.format("quarter to %s", WORDS[nextHour]);
        } else if (m == 1) {
            return String.format("%s minute past %s", WORDS[m], WORDS[h]);
        } else if (m <= 30) {
            return String.format("%s minutes past %s", WORDS[m], WORDS[h]);
        } else if (m == 59) {
            return String.format("%s minute to %s", WORDS[60 - m], WORDS[nextHour]);
        } else {
            return String.format("%s minutes to %s", WORDS[60 - m], WORDS[nextHour]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);
        System.out.println(result);

        scanner.close();
    }
}
