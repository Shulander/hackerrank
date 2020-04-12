package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ViralAdvertising {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int result = viralAdvertising(n, 5);
        return result;
    }


    private static int viralAdvertising(int day, int shared) {
        if (day <= 0) {
            return 0;
        }
        int liked = Math.floorDiv(shared, 2);
        int cumulative = viralAdvertising(day - 1, liked * 3);
        return liked + cumulative;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);
        System.out.println(result);

        scanner.close();
    }
}
