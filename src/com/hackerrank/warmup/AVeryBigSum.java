/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.warmup;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * Sample Input
 * 5
 * 1000000001 1000000002 1000000003 1000000004 1000000005
 * 
 * Output
 * Print a single value equal to the sum of the elements in the array. In the above sample, you would print 
 * 50000000155000000015.
 * 
 * @author Shulander
 */
public class AVeryBigSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger result = BigInteger.ZERO;

        int n = in.nextInt();
        while (n-- > 0) {
            result = result.add(BigInteger.valueOf(in.nextLong()));
        }
        System.out.println(result);
    }
}
