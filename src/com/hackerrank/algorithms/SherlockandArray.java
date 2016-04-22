package com.hackerrank.algorithms;

import com.hackerrank.datastructures.Array1DPart2;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * 
 * @author Shulander
 */
public class SherlockandArray {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int nValues = myScan.nextInt();
            int[] arrayValues = new int[nValues];

            for (int i = 0; i < nValues; i++) {
                arrayValues[i] = myScan.nextInt();
            }
            System.out.println(checkArmSums(arrayValues)?"YES":"NO");
        }
    }

    private static boolean checkArmSums(int[] arrayValues) {
        int left = 0;
        int right=0;
        for (int arrayValue : arrayValues) {
            right+= arrayValue;
        }
        for (int i = 0; i < arrayValues.length; i++) {
            right -= arrayValues[i];
            if(left == right) {
                return true;
            }
            left += arrayValues[i];
        }
        return false;
    }
}
