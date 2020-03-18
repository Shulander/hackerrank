package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int best = scores[0];
        int worst = scores[0];
        int nBest = 0;
        int nWorst = 0;

        for (int i = 1; i < scores.length; i++) {
            int score = scores[i];
            if (score > best) {
                best = score;
                nBest++;
            } else if (score < worst) {
                worst = score;
                nWorst++;
            }
        }

        return new int[]{nBest, nWorst};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        String resultStr = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(resultStr);
        scanner.close();
    }
}
