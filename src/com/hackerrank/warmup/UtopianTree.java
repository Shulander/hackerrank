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
public class UtopianTree {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        long a;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            int treeHeight=1;
            for(int j=0;j<a;j++) {
                if(j%2==0) {
                    treeHeight*=2;
                } else {
                    treeHeight++;
                }
            }
            System.out.println(treeHeight);
        }
    }

}
