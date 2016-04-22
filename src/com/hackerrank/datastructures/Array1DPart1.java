package com.hackerrank.datastructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * https://www.hackerrank.com/challenges/java-1d-array-easy
 * 
 * @author Shulander
 */
public class Array1DPart1 {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nValues = myScan.nextInt();
        int[] arrayValues = new int[nValues];

        for (int i = 0; i < nValues; i++) {
            arrayValues[i] = myScan.nextInt();
        }

        System.out.println(findNegativeSubArray(arrayValues));
    }

    private static int findNegativeSubArray(int[] arrayValues) {
        int returnValue = 0;
        for (int i = 0; i < arrayValues.length; i++) {
            for (int j = i; j < arrayValues.length; j++) {
                if(isSubArrayNegative(arrayValues, i, j)) {
                    returnValue++;
                }
            }
        }
        
        return returnValue;
    }

    private static boolean isSubArrayNegative(int[] arrayValues, int i, int j) {
        int sum=0;
        for(int k=i; k<=j; k++) {
            sum+=arrayValues[k];
        }
        return sum<0;
    }

}