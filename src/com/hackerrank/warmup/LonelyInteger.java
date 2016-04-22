package com.hackerrank.warmup;

import java.util.*;

public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if(mySet.contains(a[i])){
                mySet.remove(a[i]);
            } else {
                mySet.add(a[i]);
            }
        }
        return mySet.isEmpty()?a[0]:mySet.iterator().next();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }
}