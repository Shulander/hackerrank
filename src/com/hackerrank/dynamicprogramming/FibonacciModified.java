package com.hackerrank.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * https://www.hackerrank.com/challenges/fibonacci-modified/submissions/code/19249036
 * 
 * Sample Input
 * 0 1 5  
 * 
 * Sample Output
 * 5
 * 
 * @author Shulander
 */
public class FibonacciModified {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);        
        long n0 = myScan.nextLong();
        long n1 = myScan.nextLong();
        long nn = myScan.nextLong();
        
        System.out.println(calculateFibonacci(BigInteger.valueOf(n0), BigInteger.valueOf(n1), nn));        
    }

    private static BigInteger calculateFibonacci(BigInteger n0, BigInteger n1, long nn) {
        if(nn == 0) {
            return BigInteger.ZERO;
        } else if(nn == 1) {
            return n0;
        } else if(nn == 2) {
            return n1;
        }
        
        BigInteger aux = n1.pow(2).add(n0);
        
        return calculateFibonacci(n1, aux, nn-1);
    }
}
