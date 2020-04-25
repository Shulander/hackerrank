package us.vicentini.hackerrank.algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] fib = new BigInteger[3];
        fib[0] = BigInteger.valueOf(t1);
        fib[1] = BigInteger.valueOf(t2);

        for (int i = 2; i < n; i++) {
            fib[i % 3] = fib[(i - 2) % 3].add((fib[(i - 1) % 3].pow(2)));
        }

        return fib[(n - 1) % 3];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);

        scanner.close();
    }
}
