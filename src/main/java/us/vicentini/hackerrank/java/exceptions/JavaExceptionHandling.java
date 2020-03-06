package us.vicentini.hackerrank.java.exceptions;

import java.util.Scanner;

class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return ((int) Math.pow(n, p));
    }
}


public class JavaExceptionHandling {
    public static void main(String[] args) {
        final MyCalculator my_calculator = new MyCalculator();
        final Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
