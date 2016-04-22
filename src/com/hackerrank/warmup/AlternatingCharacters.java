/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.warmup;

import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String input = in.nextLine();
            if (input.trim().isEmpty()) {
                i--;
                continue;
            }
            System.out.println(findShashank(input));
        }
    }
    
    private static Integer findShashank(String input) {
        String newStr = input;
        int inputLenght;
        do {
            inputLenght = newStr.length();
            newStr = newStr.replaceAll("AA", "A");
            newStr = newStr.replaceAll("BB", "B");
        } while(newStr.length() < inputLenght);
        
        return input.length()-newStr.length();
    }

}
