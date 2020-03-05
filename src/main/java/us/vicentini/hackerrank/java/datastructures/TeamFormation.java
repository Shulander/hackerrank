/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.java.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Shulander
 */
public class TeamFormation {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int nConstestants = myScan.nextInt();
            int[] players = new int[nConstestants];

            for (int i = 0; i < players.length; i++) {
                players[i] = myScan.nextInt();
            }

            System.out.println(processTeamFormation(players));
        }
    }

    private static int processTeamFormation(int[] players) {
        if(players.length == 0) {
            return 0;
        }
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        int returnValue = Integer.MAX_VALUE;
        Arrays.sort(players);
        for (int i = 0; i < players.length; i++) {
            addToList(lists, players[i]);
        }

        returnValue = findShorterList(lists);
        return returnValue;
    }

    private static void addToList(List<List<Integer>> lists, int player) {
        List<Integer> newList = null;
        for (List<Integer> list : lists) {
            if (list.get(0) == (player - 1)) {
                newList = list;
            }
        }
        if(newList == null) {
            newList = new LinkedList<Integer>();
            lists.add(newList);
        }
        newList.add(0, player);
    }

    private static int findShorterList(List<List<Integer>> lists) {
        int returnValue = Integer.MAX_VALUE;
        int nelementos=0;
        for (List<Integer> list : lists) {
            for (Integer intValue : list) {
                System.out.print(intValue+" ");
            }
            System.out.println("");
            nelementos+=list.size();
            if(list.size()<returnValue) {
                returnValue = list.size();
            }
        }
        System.out.println("elementos: "+nelementos);
        return returnValue;
    }
}
