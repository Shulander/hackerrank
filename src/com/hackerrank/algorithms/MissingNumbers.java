/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.algorithms;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/missing-numbers
 *
 * @author Shulander
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nValues = myScan.nextInt();
        int[] arrayValuesA = new int[nValues];

        for (int i = 0; i < nValues; i++) {
            arrayValuesA[i] = myScan.nextInt();
        }
        nValues = myScan.nextInt();
        int[] arrayValuesB = new int[nValues];

        for (int i = 0; i < nValues; i++) {
            arrayValuesB[i] = myScan.nextInt();
        }
        System.out.println(findMissingValues(arrayValuesA, arrayValuesB));
    }

    private static String findMissingValues(int[] arrayValuesA, int[] arrayValuesB) {
        Map<Integer, Integer> subMap = new TreeMap<>();

        for (int tmp : arrayValuesA) {
            if (subMap.containsKey(tmp)) {
                subMap.put(tmp, subMap.get(tmp) + 1);
            } else {
                subMap.put(tmp, 1);
            }
        }

        for (int tmp : arrayValuesB) {
            if (subMap.containsKey(tmp)) {
                subMap.put(tmp, subMap.get(tmp) - 1);
            } else {
                subMap.put(tmp, -1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> keySet : subMap.entrySet()) {
            if (keySet.getValue() != 0) {
                sb.append(keySet.getKey()).append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
