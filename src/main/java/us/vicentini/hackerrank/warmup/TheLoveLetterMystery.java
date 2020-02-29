package us.vicentini.hackerrank.warmup;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shulander
 */
public class TheLoveLetterMystery {

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
            System.out.println(computeLoveLetter(input));
        }
    }

    private static int computeLoveLetter(String input) {
        int returnValue = 0;
        
        int halfSize = (input.length()+1)/2;
        for (int i = 0; i < halfSize; i++) {
            char a = input.charAt(i);
            char b = input.charAt(input.length()-(i+1));
            returnValue+= (a>b?a-b:b-a);
        }
        
        return returnValue;
    }
}
