package com.hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
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
        quickSort(strArray, changedIdx+1, strArray.length - 1);
        return new String(strArray);
    }

    private static int pivotLeastValuable(char[] strArray, int startIdx) {
        if (startIdx < 0) {
            return startIdx;
        }
        for (int comparableIdx = startIdx - 1; comparableIdx >= 0; comparableIdx--) {
            if (strArray[startIdx] > strArray[comparableIdx]) {
                char aux = strArray[startIdx];
                strArray[startIdx] = strArray[comparableIdx];
                strArray[comparableIdx] = aux;
                return comparableIdx;
            }
        }
        return pivotLeastValuable(strArray, startIdx - 1);
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
