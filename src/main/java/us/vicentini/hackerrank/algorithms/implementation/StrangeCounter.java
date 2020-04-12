package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long value = 3;
        long time = 1;
        while (value + time <= t) {
            time = time + value;
            value = value * 2;
        }
        long result = value - (t - time);

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);
        System.out.println(result);

        scanner.close();
    }
}
