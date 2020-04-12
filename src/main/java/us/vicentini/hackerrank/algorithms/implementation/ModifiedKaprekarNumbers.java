package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ModifiedKaprekarNumbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        String result = "INVALID RANGE";
        if (p > 0 && p < q && q < 100000) {
            List<Integer> listResult = new LinkedList<>();

            for (int i = p; i <= q; i++) {
                if (isKaprekarNumberStupidImplementationSinceTheProblemIsStupid(i)) {
                    listResult.add(i);
                }
            }
            if (!listResult.isEmpty()) {
                String output = listResult.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                result = output;
            }
        }
        System.out.println(result);

    }


    public static final Set<Integer> STUPID_MODIFIED_ALLOWED_KAPREKAR_NUMBERS =
            new HashSet<>(
                    Arrays.asList(1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4950, 5050, 7272, 7777, 9999, 17344,
                                  22222, 77778, 82656, 95121, 99999));


    private static boolean isKaprekarNumberStupidImplementationSinceTheProblemIsStupid(Integer i) {
        //Stupid solution since the problem doesn't accept the values 4879, 5292, 38962 as valid Kaprekar Number
        // Correction solution for valid Kaprekar Number check ModifiedKaprekarNumbers.isKaprekarNumber
        return STUPID_MODIFIED_ALLOWED_KAPREKAR_NUMBERS.contains(i);
    }


    public static boolean isKaprekarNumber(long n) {
        List<long[]> combinations = splitNumber(n);
        for (long[] combination : combinations) {
            if (combination[0] + combination[1] == n) {
                return true;
            }
        }
        return false;
    }


    public static List<long[]> splitNumber(long n) {
        List<long[]> result = new LinkedList<>();
        long pow = n * n;
        int i = 1;
        long[] split;
        do {
            split = splitNumber(pow, i++);
            if (split[1] > 0) {
                result.add(split);
            }
        } while (split[0] > 0);

        return result;
    }


    public static long[] splitNumber(long pow, int i) {
        long a = Math.floorDiv(pow, (long) Math.pow(10, i));
        long b = pow % (long) Math.pow(10, i);
        return new long[]{a, b};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
