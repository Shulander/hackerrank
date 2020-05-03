package us.vicentini.hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BeautifulTriplets {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int result = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.compute(i, (a, b) -> b == null ? 1 : b + 1);
        }


        for (int i = 1; i < arr.length - 1; i++) {
            int value = arr[i];
            result += count.getOrDefault(value - d, 0) * count.getOrDefault(value + d, 0);
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        System.out.println(result);

        scanner.close();
    }
}
