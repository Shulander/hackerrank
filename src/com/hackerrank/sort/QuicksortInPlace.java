/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.sort;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort3
 * https://www.hackerrank.com/challenges/quicksort3/submissions/code/19248703
 *
 * Sample Input 7 1 3 9 8 2 7 5
 *
 * Sample Output 1 3 2 5 9 7 8 1 2 3 5 9 7 8 1 2 3 5 7 8 9
 *
 *
 * @author Shulander
 */
public class QuicksortInPlace {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nValues = myScan.nextInt();
        int[] arrayValuesA = new int[nValues];

        for (int i = 0; i < nValues; i++) {
            arrayValuesA[i] = myScan.nextInt();
        }

        quickSort(arrayValuesA, 0, arrayValuesA.length - 1);
    }

    private static void quickSort(int[] arrayValuesA, int ini, int end) {
        if (ini >= end) {
            return;
        }
        int i = 0;
        int j = 0;
        for (; j < end; j++) {
            if (arrayValuesA[j] <= arrayValuesA[end]) {
                swap(arrayValuesA, i, j);
                i++;
            }
        }
        swap(arrayValuesA, i, end);
        print(arrayValuesA);
        quickSort(arrayValuesA, ini, i - 1);
        quickSort(arrayValuesA, i + 1, end);
    }

    private static void swap(int[] arrayValuesA, int i, int j) {
        if (i != j) {
            int tmp = arrayValuesA[i];
            arrayValuesA[i] = arrayValuesA[j];
            arrayValuesA[j] = tmp;
        }

    }

    private static void print(int[] arrayValuesA) {
        for (int i = 0; i < arrayValuesA.length; i++) {
            System.out.print(arrayValuesA[i] + " ");
        }
        System.out.println("");
    }
}
