package com.hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertion-sort/submissions/code/19401019
 *
 * Sample Input 2 5 1 1 1 2 2 5 2 1 3 1 2
 *
 * Sample Output 0 4
 *
 * @author Shulander
 */
public class InsertionSortAdvancedAnalysis {

    private final int[] ar;

    private InsertionSortAdvancedAnalysis(int[] ar) {
        this.ar = ar;
    }

    private long sort() {
        return insertIntoSorted(0, ar.length - 1);
    }

    public long insertIntoSorted(int ini, int end) {
        long moves = 0;
        if (end - ini <=1) {
            for (int i = ini + 1; i <= end; i++) {
                int aux = i;
                int value = ar[i];
                while (aux > ini && value < ar[aux - 1]) {
                    ar[aux] = ar[aux - 1];
                    aux--;
                    moves++;
                }
                ar[aux] = value;
            }
        } else {
            int middle = ((end - ini) / 2) + ini;
            moves += insertIntoSorted(ini, middle);
            moves += insertIntoSorted(middle + 1, end);

            for (int i = middle + 1; i <= end; i++) {
                int aux = i;
                int value = ar[i];
                while (aux > ini && value < ar[aux - 1]) {
                    ar[aux] = ar[aux - 1];
                    aux--;
                    moves++;
                }
                ar[aux] = value;
            }
        }
        return moves;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        InsertionSortAdvancedAnalysis[] threads = new InsertionSortAdvancedAnalysis[n];
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();

            int[] ar = new int[s];
            for (int j = 0; j < s; j++) {
                ar[j] = in.nextInt();
            }
            InsertionSortAdvancedAnalysis insertinoSort = new InsertionSortAdvancedAnalysis(ar);
            threads[i] = insertinoSort;
        }

        
        long ini = System.currentTimeMillis();
        long tmp = ini;
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].sort());
            System.out.println(String.format("%.3f", (System.currentTimeMillis()-tmp) / 1000.0));
            tmp = System.currentTimeMillis();
        }
        System.out.println(String.format("%.3f", (System.currentTimeMillis()-ini) / 1000.0));
        
    }

}
