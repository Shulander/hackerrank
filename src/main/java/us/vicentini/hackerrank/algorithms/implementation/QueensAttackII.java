package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class QueensAttackII {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[] fObstacles = filterObstacles(n, r_q, c_q, obstacles);
        int value = 0;
        for (int fObstacle : fObstacles) {
            value += fObstacle;
        }
        return value;
    }


    private static int[] filterObstacles(int n, int r_q, int c_q, int[][] obstacles) {
        int[] result = new int[8];
        // r==0
        result[0] = c_q - 1;
        result[1] = n - c_q;
        // c==0
        result[2] = r_q - 1;
        result[3] = n - r_q;
        //
        result[4] = Math.min(c_q - 1, r_q - 1);
        result[5] = Math.min(c_q - 1, n - r_q);
        result[6] = Math.min(n - c_q, r_q - 1);
        result[7] = Math.min(n - c_q, n - r_q);


        for (int[] obstacle : obstacles) {
            int r = obstacle[0] - r_q;
            int c = obstacle[1] - c_q;
            if (r == 0 || c == 0) {
                if (r == 0) {
                    if (c < 0) {
                        result[0] = Math.min(result[0], Math.abs(c) - 1);
                    } else if (c > 0) {
                        result[1] = Math.min(result[1], Math.abs(c) - 1);
                    }
                } else {
                    if (r < 0) {
                        result[2] = Math.min(result[2], Math.abs(r) - 1);
                    } else if (r > 0) {
                        result[3] = Math.min(result[3], Math.abs(r) - 1);
                    }
                }
            } else if (Math.abs(r) == Math.abs(c)) {
                if (c < 0) {
                    if (r < 0) {
                        result[4] = Math.min(result[4], Math.abs(c) - 1);
                    } else if (r > 0) {
                        result[5] = Math.min(result[5], Math.abs(c) - 1);
                    }
                } else {
                    if (r < 0) {
                        result[6] = Math.min(result[6], Math.abs(c) - 1);
                    } else if (r > 0) {
                        result[7] = Math.min(result[7], Math.abs(c) - 1);
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }
}
