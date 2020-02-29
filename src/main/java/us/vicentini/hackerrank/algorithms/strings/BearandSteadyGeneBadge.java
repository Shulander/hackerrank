package us.vicentini.hackerrank.algorithms.strings;

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
public class BearandSteadyGeneBadge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nGens = in.nextInt();
        while (nGens-- > 0) {
            String input = in.next();
            
            
            int solution = solve(input, nGens);
            System.out.println(solution);
        }
    }

    private static int solve(String input, int nGens) {
        char[] charArray = input.toUpperCase().toCharArray();
        int a = nGens/4;
        int c,t,g;
        c=a;
        t=a;
        g=a;
        
        char lastChar = '-';
        for (int i = 0; i < charArray.length; i++) {
            switch(charArray[i]) {
                case 'A':
                    a--;
                    break;
                case 'C':
                    c--;
                    break;
                case 'G':
                    g--;
                    break;
                case 'T':
                    t--;
                    break;
            }
        }
        return 0;
    }
}
