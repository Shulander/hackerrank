package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class HalloweenSale {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int games = 0;
        int max = p;
        while (max <= s) {
            games++;
            p -= d;
            if (p < m) {
                p = m;
            }
            max += p;
        }
        return games;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        System.out.println(answer);

        scanner.close();
    }
}
