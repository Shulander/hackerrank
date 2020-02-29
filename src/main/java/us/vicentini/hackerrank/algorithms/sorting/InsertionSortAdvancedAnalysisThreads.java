package us.vicentini.hackerrank.algorithms.sorting;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://www.hackerrank.com/challenges/insertion-sort/submissions/code/19401019
 *
 * Sample Input 2 5 1 1 1 2 2 5 2 1 3 1 2
 *
 * Sample Output 0 4
 *
 * @author Shulander
 */
public class InsertionSortAdvancedAnalysisThreads extends Thread {

    private final int[] ar;
    private long result;

    private InsertionSortAdvancedAnalysisThreads(int[] ar) {
        this.ar = ar;
        this.result = 0;
    }

    public long insertIntoSorted(int ini, int end) throws InterruptedException {
        long moves = 0;
        if (end - ini < 5) {
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
//            SplitRunnable sr1 = new SplitRunnable(ar, ini, middle);
//            SplitRunnable sr2 = new SplitRunnable(ar, middle + 1, end);
//            sr1.start();
//            sr2.start();
//            sr1.join();
//            sr2.join();
//            moves+=sr1.getResult();
//            moves+=sr2.getResult();
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
        InsertionSortAdvancedAnalysisThreads[] threads = new InsertionSortAdvancedAnalysisThreads[n];
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();

            int[] ar = new int[s];
            for (int j = 0; j < s; j++) {
                ar[j] = in.nextInt();
            }
            InsertionSortAdvancedAnalysisThreads insertinoSort = new InsertionSortAdvancedAnalysisThreads(ar);
            threads[i] = insertinoSort;
        }

        System.out.println(String.format("%.3f", System.currentTimeMillis() / 1000.0));
        
        for (int i = 0; i < threads.length; i++) {
            threads[i].setPriority(Thread.MAX_PRIORITY-i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
            System.out.println(threads[i].getResult());
        }
        System.out.println(String.format("%.3f", System.currentTimeMillis() / 1000.0));
    }

    @Override
    public void run() {
        try {
            result = insertIntoSorted(0, ar.length - 1);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public long getResult() {
        return result;
    }

    private class SplitRunnable extends Thread {

        private final int ini;
        private final int end;

        private long result;

        SplitRunnable(int[] ar, int ini, int end) {
            this.ini = ini;
            this.end = end;
            result = 0;
        }

        @Override
        public void run() {
            try {
                result = insertIntoSorted(ini, end);
            } catch (InterruptedException ex) {
                Logger.getLogger(InsertionSortAdvancedAnalysisThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public long getResult() {
            return result;
        }

    }

}
