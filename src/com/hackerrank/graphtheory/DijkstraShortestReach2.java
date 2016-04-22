/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.graphtheory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 * https://www.hackerrank.com/challenges/dijkstrashortreach/submissions/code/19250604
 * 
 * Sample Input
 * 1
 * 4 4
 * 1 2 24
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 * 
 * Sample Output
 * 24 3 15
 * 
 * @author Shulander
 */
public class DijkstraShortestReach2 {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int nNodes = myScan.nextInt();
            int nVertices = myScan.nextInt();
            Graph g = new Graph(nNodes);
            for (int i = 0; i < nVertices; i++) {
                g.addVertice(myScan.nextInt()-1, myScan.nextInt()-1, myScan.nextInt());
            }
            int start = myScan.nextInt()-1;
            g.start(start);
            g.print(start);
        }
    }

    private static class Graph {
        private final int[] estimativa;
        private final int[] precedentes;
        
        private final HashMap<Integer, HashMap<Integer, Integer>> ways;
        private final boolean[] closed;
        private final int nNodes;
        
        
        private Graph(int nNodes) {
            this.nNodes = nNodes;
            estimativa = new int[nNodes];
            precedentes = new int[nNodes];
            closed = new boolean[nNodes];
            ways = new HashMap<>();
            
        }
        
        private void init(int start) {
            for (int i = 0; i < nNodes; i++) {
                estimativa[i] = Integer.MAX_VALUE;
                precedentes[i] = -1;
                closed[i] = false;
            }
            estimativa[start] = 0;
            precedentes[start] = 0;
        }

        private void addVertice(int a, int b, int value) {
            if(!ways.containsKey(a)) {
                ways.put(a, new HashMap<>());
            }
            if(!ways.containsKey(b)) {
                ways.put(b, new HashMap<>());
            }
            if(ways.get(a).containsKey(b)) {
                Integer tmp = ways.get(a).get(b);
                if(value<tmp) {
                    ways.get(a).put(b, value);
                }
            } else {
                ways.get(a).put(b, value);
            }
            if(ways.get(b).containsKey(a)) {
                Integer tmp = ways.get(b).get(a);
                if(value<tmp) {
                    ways.get(b).put(a, value);
                }
            } else {
                ways.get(b).put(a, value);
            }
        }

        private void start(int start) {
            init(start);
            Set<String> processed = new TreeSet<>();
            
            int ab;
            
            Integer a;
            while((a = findNextNonClosed())>=0) {
                for (Integer b: ways.get(a).keySet()) {
                    if(!processed.contains(a+"-"+b)) {
                        ab = ways.get(a).get(b);
                        if((ab+estimativa[a]) < estimativa[b]) {
                            estimativa[b] =(ab+estimativa[a]);
                            precedentes[b] = a;
                        }
                        processed.add(a+"-"+b);
                    }
                }
                closed[a] = true;
            }
        }
        
        public void print(int ignore) {
            for (int i = 0; i < nNodes; i++) {
                if(i!=ignore) {
                    if(Integer.MAX_VALUE == estimativa[i]) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(estimativa[i]+" ");
                    }
                }
            }
            System.out.println("");
        }

        private Integer findNextNonClosed() {
            int aux = Integer.MAX_VALUE;
            int returnValue=-1;
            for (int i = 0; i < nNodes; i++) {
                if(!closed[i] && estimativa[i]<aux) {
                    returnValue = i;
                    aux = estimativa[i];
                }
            }
            return returnValue;
        }
    }

}
