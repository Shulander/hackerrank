package com.hackerrank.security.cryptography;

import java.util.Random;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/prng-sequence-guessing
 * https://www.hackerrank.com/challenges/prng-sequence-guessing/submissions/code/21558839
 * 
 * Sample Input
 * 2
 * 1374037200 1374123600
 * 643
 * 953
 * 522
 * 277
 * 464
 * 366
 * 321
 * 409
 * 227
 * 702
 * 1374037299 1374143600
 * 877
 * 654
 * 2
 * 715
 * 229
 * 255
 * 712
 * 267
 * 19
 * 832
 * 
 * Sample Output
 * 1374037200 877 633 491 596 839 875 923 461 27 826
 * 1374037459 101 966 573 339 784 718 949 934 62 368
 *
 * @author Shulander
 */
public class PRNGSequenceGuessing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nTests = in.nextInt();
        while (nTests-- > 0) {
            try {
                int startTimestamp = in.nextInt();
                int finishTimestamp = in.nextInt();
                int[] randomValues = new int[10];
                for (int i = 0; i < randomValues.length; i++) {
                    randomValues[i] = in.nextInt();
                }
                Thread thread = new Thread(new PRNGSequenceSolver(startTimestamp, finishTimestamp, randomValues));
                thread.start();
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println("Error, Interrupted Exception: " + ex.getMessage());
            }
        }
    }

    private static class PRNGSequenceSolver implements Runnable {

        private final int iniTime;
        private final int endTime;
        private final int[] generatedValues;

        private PRNGSequenceSolver(int iniTimestamp, int endTimestamp, int[] randomValues) {
            this.iniTime = iniTimestamp;
            this.endTime = endTimestamp;
            this.generatedValues = randomValues;
        }

        @Override
        public void run() {
            int seed = -1;
            Random random = null;
            for (int i = iniTime; i <= endTime && seed == -1; i++) {

                random = new Random(i);
                if (checkSeed(random)) {
                    seed = i;
                }
            }

            generateOutput(seed, random);
        }

        private boolean checkSeed(Random random) {
            for (int i = 0; i < generatedValues.length; i++) {
                int newGenerated = random.nextInt(1000);
                if (newGenerated != generatedValues[i]) {
                    return false;
                }
            }
            return true;
        }

        private void generateOutput(int seed, Random random) {
            StringBuilder sb = new StringBuilder();
            sb.append(seed);
            if (seed > 0) {
                for (int i = 0; i < 10; i++) {
                    sb.append(" ");
                    sb.append(random.nextInt(1000));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
