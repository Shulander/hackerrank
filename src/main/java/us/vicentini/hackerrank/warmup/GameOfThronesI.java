/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.warmup;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Shulander
 */
public class GameOfThronesI {

    static String hasPalindromePermutation(String str) {
        char[] strCharArray = str.toCharArray();
        Set<Character> mySet = new HashSet<>();
        for (int i = 0; i < strCharArray.length; i++) {
            if (mySet.contains(strCharArray[i])) {
                mySet.remove(strCharArray[i]);
            } else {
                mySet.add(strCharArray[i]);
            }
        }
        return mySet.size()<=1?"YES": "NO";
    }

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        ans = hasPalindromePermutation(inputString);
        System.out.println(ans);
        myScan.close();
    }
}
