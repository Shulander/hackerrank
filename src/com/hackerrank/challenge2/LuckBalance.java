package com.hackerrank.challenge2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import javafx.scene.layout.Priority;

/**
 *
 * @author Shulander
 */
public class LuckBalance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int contests = in.nextInt();
        int importantLosable = in.nextInt();

        int[] luckBalanced = new int[contests];
        boolean[] importance = new boolean[contests];

        for (int i = 0; i < contests; i++) {
            luckBalanced[i] = in.nextInt();
            importance[i] = in.nextInt() == 1;
        }

        System.out.println(solve(contests, importantLosable, luckBalanced, importance));
    }

    private static int solve(int nContests, int nImportantLosable, int[] luckBalanced, boolean[] importance) {

        int returnValue = 0;
        PriorityQueue<Integer> importantQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o1 - o2);

        for (int i = 0; i < nContests; i++) {

            if (importance[i]) {
                if (importantQueue.size() < nImportantLosable) {
                    importantQueue.offer(luckBalanced[i]);
                    returnValue += luckBalanced[i];
                } else if (nImportantLosable > 0 && importantQueue.size() == nImportantLosable) {
                    if (importantQueue.peek() < luckBalanced[i]) {
                        returnValue -= (importantQueue.poll() * 2);
                        importantQueue.offer(luckBalanced[i]);
                        returnValue += luckBalanced[i];
                    } else {
                        returnValue -= luckBalanced[i];
                    }
                }
            } else {
                returnValue += luckBalanced[i];
            }
        }

        return returnValue;
    }
}
