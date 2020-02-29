/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.warmup;

import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class MaximizingXOR {
    static int maxXor(int l, int r) {
        int returnValue=0;
        int tmp;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                tmp = i^j;
                if(tmp>returnValue) {
                    returnValue=tmp;
                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
