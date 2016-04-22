/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class LarrysArray {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int nElements = myScan.nextInt();
            int[] data = new int[nElements];
            for (int i = 0; i < nElements; i++) {
                data[i] = myScan.nextInt();
            }
            System.out.println(checkSortable(data)?"YES":"NO");
        }
    }

    private static boolean checkSortable(int[] data) {
        int i = 0;
        int j = data.length-3;
        boolean restart = false;
        boolean returnValue = true;
        do{
            returnValue = true;
            restart = false;
            i=0;
            while (i <= j) {
                if(!sorted(data, i)) {
                    if(!trySort(data, i)) {
                        returnValue=false;       
                    }
                }
                i++;
            }
            j--;
        } while(j>=0);
        return returnValue;
    }

    private static boolean sorted(int[] a, int i) {
        return a[i]<=a[i+1] && a[i+1]<=a[i+2];
    }

    private static boolean trySort(int[] data, int i) {
        for (int j = 0; j < 3 && !(data[i+2]>data[i+1] && data[i+2]>data[i]); j++) {
            rotate(data, i);
            if(sorted(data, i)) {
                return true;
            }
        }
        return false;
    }

    private static void rotate(int[] data, int i) {
        int aux = data[i];
        data[i] = data[i+1];
        data[i+1] = data[i+2];
        data[i+2] = aux;
    }
}
