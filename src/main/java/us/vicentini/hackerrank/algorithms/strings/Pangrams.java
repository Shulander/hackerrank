/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 * https://www.hackerrank.com/challenges/pangrams/submissions/code/19399361
 * 
 * Sample Input
 * Input #1
 * We promptly judged antique ivory buckles for the next prize    
 * Input #2
 * We promptly judged antique ivory buckles for the prize    
 * 
 * Sample Output
 * Output #1
 * pangram
 * Output #2
 * not pangram
 * 
 * @author Shulander
 */
public class Pangrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(isPangrams(str)?"pangram":"not pangram");
    }

    private static boolean isPangrams(String str) {
        str = str.toLowerCase();

        int charAValue = Character.getNumericValue('a');
        int charZValue = Character.getNumericValue('z');
        boolean allChars[] = new boolean[charZValue - charAValue + 1];
        for (int i = 0; i < allChars.length; i++) {
            allChars[i] = false;
        }

        char[] array = str.toCharArray();
        for (char b : array) {
            int charValue = Character.getNumericValue(b);
            if (charValue >= charAValue && charValue <= charZValue) {
                allChars[charValue-charAValue] = true;
            }
        }
        
        for (int i = 0; i < allChars.length; i++) {
            if(!allChars[i]) {
                return false;
            }
        }
        return true;
    }
}
