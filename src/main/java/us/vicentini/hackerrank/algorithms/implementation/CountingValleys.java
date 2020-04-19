package us.vicentini.hackerrank.algorithms.implementation;


import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        boolean aboveSeaLevel = true;
        int level = 0;
        int valleys = 0;

        for (char c : s.toCharArray()) {
            if (c == 'U') {
                level++;
            } else if (c == 'D') {
                level--;
            }

            if (!aboveSeaLevel && level >= 0) {
                valleys++;
            }
            aboveSeaLevel = level >= 0;
        }


        return valleys;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}
