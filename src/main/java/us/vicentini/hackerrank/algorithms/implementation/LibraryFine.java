package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class LibraryFine {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int result = 0;
        if (y1 > y2) {
            result = 10000 * (y1 - y2);
        } else if (y1 == y2) {
            if (m1 > m2) {
                result = 500 * (m1 - m2);
            } else if (m1 == m2 && d1 > d2) {
                result = 15 * (d1 - d2);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        System.out.println(result);

        scanner.close();
    }
}
