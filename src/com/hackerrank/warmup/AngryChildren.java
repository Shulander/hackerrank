/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Shulander
 */
public class AngryChildren {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numPackets = Integer.parseInt(in.readLine());
        int numKids = Integer.parseInt(in.readLine());
        int[] packets = new int[numPackets];

        for (int i = 0; i < numPackets; i++) {
            packets[i] = Integer.parseInt(in.readLine());
        }

        // Write your code here, to process numPackets N, numKids K, and the packets of candies
        // Compute the ideal value for unfairness over here
        int unfairness = calculateUnfairness(packets, numKids);
        
        System.out.println(unfairness);
    }

    private static int calculateUnfairness(int[] packets, int numKids) {
        Arrays.sort(packets);
        
        int unfairness = Integer.MAX_VALUE;
        int tmp;
        for (int i = 0; i <= (packets.length-numKids); i++) {
            tmp = packets[i+numKids-1]-packets[i];
            if(tmp<unfairness) {
                unfairness=tmp;
            }
        }
        return unfairness;
    }
}
