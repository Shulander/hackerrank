package com.hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 * https://www.hackerrank.com/challenges/bigger-is-greater/submissions/code/21525491
 * 
 * Sample Input
 * 5
 * ab
 * bb
 * hefg
 * dhck
 * dkhc
 * 
 * Sample Output
 * ba
 * no answer
 * hegf
 * dhkc
 * hcdk
 * 
 * @author Shulander
 */
public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String result = biggerIsGreater(str);
            System.out.println(result);
        }
    }

    private static String biggerIsGreater(String str) {
        char[] strArray = str.toCharArray();
        int changedIdx = pivotLeastValuable(strArray, strArray.length - 1);
        if (changedIdx < 0) {
            return "no answer";
        }
        quickSort(strArray, changedIdx + 1, strArray.length - 1);
        return new String(strArray);
    }

    private static int pivotLeastValuable(char[] strArray, int startIdx) {
        if (startIdx < 0) {
            return startIdx;
        }
        int idxFound = -1;
        int idxFrom = -1;
        for (; startIdx > 0 && startIdx > idxFound; startIdx--) {
            for (int comparableIdx = startIdx - 1; comparableIdx >= 0; comparableIdx--) {
                if (strArray[startIdx] > strArray[comparableIdx] && comparableIdx > idxFound) {
                    idxFound = comparableIdx;
                    idxFrom = startIdx;
                }
            }
        }
        if (idxFound > -1) {
            char aux = strArray[idxFrom];
            strArray[idxFrom] = strArray[idxFound];
            strArray[idxFound] = aux;
        }
        return idxFound;
    }

    private static void quickSort(char[] arrayValuesA, int ini, int end) {
        if (ini >= end) {
            return;
        }
        int i = ini;
        int j = ini;
        for (; j < end; j++) {
            if (arrayValuesA[j] <= arrayValuesA[end]) {
                swap(arrayValuesA, i, j);
                i++;
            }
        }
        swap(arrayValuesA, i, end);
        quickSort(arrayValuesA, ini, i - 1);
        quickSort(arrayValuesA, i + 1, end);
    }

    private static void swap(char[] arrayValuesA, int i, int j) {
        if (i != j) {
            char tmp = arrayValuesA[i];
            arrayValuesA[i] = arrayValuesA[j];
            arrayValuesA[j] = tmp;
        }

    }
}
