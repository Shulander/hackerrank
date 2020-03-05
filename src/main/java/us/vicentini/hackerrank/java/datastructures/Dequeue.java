/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.java.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-dequeue
 * @author Shulander
 */
public class Dequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> buffer = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int i;
        for (i = 0; i < n; i++) {
            int num = in.nextInt();
            buffer.add(num);
        }
        System.out.println(findMaximumUniques(buffer, m));
    }

    private static int findMaximumUniques(Deque<Integer> buffer, int m) {
        int maximumUniques = 0;
        Map<Integer, Integer> subMap = new HashMap<>();
        Deque<Integer> subArray = new LinkedList<>();
        Integer tmp;
        for (int i = 0; i < m-1; i++) {
            tmp = buffer.removeFirst();
            if(subMap.containsKey(tmp)) {
                subMap.put(tmp, subMap.get(tmp)+1);
            } else {
                subMap.put(tmp, 1);
            }
            subArray.add(tmp);
        }

        int maximumTmp = 0;
        while (!buffer.isEmpty()) {
            tmp = buffer.removeFirst();
            if(subMap.containsKey(tmp)) {
                subMap.put(tmp, subMap.get(tmp)+1);
            } else {
                subMap.put(tmp, 1);
            }
            subArray.add(tmp);
            maximumTmp = subMap.size();
            if(maximumTmp == m) {
                return m;
            }
            if(maximumTmp>maximumUniques) {
                maximumUniques = maximumTmp;
            }
            tmp = subArray.removeFirst();
            
            if(subMap.get(tmp)>1) {
                subMap.put(tmp, subMap.get(tmp)-1);
            } else {
                subMap.remove(tmp);
            }
        } 

        return maximumUniques;

    }

}
