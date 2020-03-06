package us.vicentini.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        BigInteger aB = new BigInteger(a);
        BigInteger bB = new BigInteger(b);
        System.out.println(aB.add(bB));
        System.out.println(aB.multiply(bB));
    }
}
