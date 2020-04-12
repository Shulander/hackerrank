package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxMaxDistance = c[0];
        for (int i = 1; i < c.length; i++) {
            int cityA = c[i - 1];
            int cityB = c[i];
            int avg = Math.floorDiv(cityB - cityA, 2);
            maxMaxDistance = Math.max(maxMaxDistance, avg);
        }
        int lastDistance = ((n - 1) - c[c.length - 1]);
        maxMaxDistance = Math.max(maxMaxDistance, lastDistance);

        return maxMaxDistance;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        System.out.println(result);
        scanner.close();
    }
}
