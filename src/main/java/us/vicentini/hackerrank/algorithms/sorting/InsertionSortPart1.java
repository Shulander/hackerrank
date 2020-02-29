package us.vicentini.hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1
 * https://www.hackerrank.com/challenges/insertionsort2
 *
 * Sample Input 5 2 4 6 8 3
 *
 * Sample Output 2 4 6 8 8 2 4 6 6 8 2 4 4 6 8 2 3 4 6 8
 *
 * Sample Input 6 1 4 3 5 6 2
 *
 * Sample Output 1 4 3 5 6 2 1 3 4 5 6 2 1 3 4 5 6 2 1 3 4 5 6 2 1 2 3 4 5 6
 *
 * @author Shulander
 */
public class InsertionSortPart1 {

    public static void insertIntoSorted(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int aux = i;
            int value = ar[i];
            while (aux > 0 && value < ar[aux - 1]) {
                ar[aux] = ar[aux - 1];
                aux--;
            }
            ar[aux] = value;
            printArray(ar);
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
