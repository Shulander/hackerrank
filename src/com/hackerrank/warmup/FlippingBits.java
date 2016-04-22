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
public class FlippingBits {
    private static long MAX_UNSIGN_INTEGER = 4294967295L;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        long a,b;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextLong();
            b = flipBits(a);
            System.out.println(b);
        }
    }

    private static long flipBits(long a) {
        if(a<0) {
            a = -a;
            a=Integer.MAX_VALUE+a;
        }
        return MAX_UNSIGN_INTEGER-a;
    }
}
