package us.vicentini.hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;

        while (n > 1) {
            long startingValue = 1;
            try {
                while (n > 0) {
                    startingValue = Math.multiplyExact(startingValue, n);
                    --n;
                }
            } catch (ArithmeticException ex) {
            }
            result = result.multiply(BigInteger.valueOf(startingValue));
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
