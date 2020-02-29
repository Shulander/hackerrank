/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.graphtheory;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/primsmstsub
 * https://www.hackerrank.com/challenges/primsmstsub/submissions/code/19398964
 * 
 * Sample Input
 * 5 6
 * 1 2 3
 * 1 3 4
 * 4 2 6
 * 5 2 2
 * 2 3 5
 * 3 5 7
 * 1
 * 
 * Sample Output
 * 15
 * 
 * @author Shulander
 */
public class PrimsMSTSpecialSubtree {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nNodes = myScan.nextInt();
        int nVertices = myScan.nextInt();
        Graph g = new Graph(nNodes);
        for (int i = 0; i < nVertices; i++) {
            g.addVertice(myScan.nextInt() - 1, myScan.nextInt() - 1, myScan.nextInt());
        }
        int start = myScan.nextInt() - 1;
        g.start(start);
        g.print(start);
    }

    private static class Graph {

        private final int[] estimativa;
        private final int[] precedentes;

        private final boolean[] closed;
        private final int nNodes;

        private final Node[] nodes;
        private final PriorityQueue<Vertice> priority;

        private Graph(int nNodes) {
            this.nNodes = nNodes;

            nodes = new Node[nNodes];
            for (int i = 0; i < nNodes; i++) {
                nodes[i] = new Node(i);
            }

            estimativa = new int[nNodes];
            precedentes = new int[nNodes];
            closed = new boolean[nNodes];

            priority = new PriorityQueue<Vertice>(1, new Comparator<Vertice>() {
                @Override
                public int compare(Vertice o1, Vertice o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        private void init(int start) {
            for (int i = 0; i < nNodes; i++) {
                estimativa[i] = Integer.MAX_VALUE;
                precedentes[i] = -1;
                closed[i] = false;
            }
            estimativa[start] = 0;
            precedentes[start] = 0;
            Vertice newVertice = new Vertice(nodes[start], nodes[start], 0);
            priority.add(newVertice);
        }

        private void addVertice(int a, int b, int value) {
            nodes[a].addVertice(new Vertice(nodes[a], nodes[b], value));
            nodes[b].addVertice(new Vertice(nodes[b], nodes[a], value));
        }

        private void start(int start) {
            init(start);

            Vertice vertice;
            while ((vertice = priority.poll()) != null) {
                if (!closed[vertice.b.getId()]) {
                    estimativa[vertice.b.getId()] = vertice.weight;
                    for (Vertice newVertices : vertice.b.getVertices()) {
                        priority.add(newVertices);
                    }
                }
                closed[vertice.b.getId()] = true;
            }
        }

        public void print(int ignore) {
            int result = 0;
            for (int i = 0; i < nNodes; i++) {
                result += estimativa[i];
            }
            System.out.println(result);
        }
    }

    private static class Node {

        private final LinkedList<Object> vertices;
        private final int id;

        public Node(int id) {
            this.id = id;
            vertices = new LinkedList<>();
        }

        public Vertice[] getVertices() {
            return vertices.toArray(new Vertice[0]);
        }

        public void addVertice(Vertice v) {
            vertices.add(v);
        }

        public int getId() {
            return id;
        }
    }

    private static class Vertice implements Comparable<Vertice> {

        private final Node a;
        private final Node b;
        private final int weight;

        public Vertice(Node a, Node b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertice o) {
            if (o == null) {
                return 1;
            }

            return (weight - o.weight);
        }

    }

}
