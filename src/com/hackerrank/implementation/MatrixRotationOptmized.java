/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/submissions/code/19323991
 *  
 * Sample Input #00
 * 4 4 1
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * Sample Output #00
 * 2 3 4 8
 * 1 7 11 12
 * 5 6 10 16
 * 9 13 14 15
 * 
 * @author Shulander
 */
public class MatrixRotationOptmized {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nRows = myScan.nextInt();
        int nColls = myScan.nextInt();
        int nShifts = myScan.nextInt();

        int[][] matrix = new int[nRows][nColls];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColls; j++) {
                matrix[i][j] = myScan.nextInt();
            }
        }

        Matrix matrixRotation;
        matrixRotation = new Matrix(matrix);
        matrixRotation.rotate(nShifts);

    }

    private static class Matrix {

        private final int[][] matrix;
        private final Map<Integer, Point>[] integerToPoint;
        private final int maxGroup;

        private Matrix(int[][] matrix) {
            this.matrix = matrix;
            maxGroup = Math.min(matrix.length, matrix[0].length) / 2;
            integerToPoint = new Map[maxGroup];
        }

        private void rotate(int nShifts) {
            createStructure();
            calculateAndPrint(nShifts);
        }

        private void createStructure() {
            for (int i = 0; i < maxGroup; i++) {
                integerToPoint[i] = new HashMap<>();
                loadStructure(i);
            }
        }

        private void loadStructure(int group) {
            int rows = matrix.length - group;
            int colls = matrix[0].length - group;

            int i = group;
            int j = group;

            int reference = 0;

            while (j < colls) {
                Point p = new Point(i, j);
                integerToPoint[group].put(reference, p);
                j++;
                reference++;
            }
            j--;
            i++;
            while (i < rows) {
                Point p = new Point(i, j);
                integerToPoint[group].put(reference, p);
                i++;
                reference++;
            }
            i--;
            j--;
            while (j >= group) {
                Point p = new Point(i, j);
                integerToPoint[group].put(reference, p);
                j--;
                reference++;
            }
            j++;
            i--;
            while (i > group) {
                Point p = new Point(i, j);
                integerToPoint[group].put(reference, p);
                i--;
                reference++;
            }
        }

        private void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }
        }

        private void calculateAndPrint(int nShifts) {
            int[][] result = new int[matrix.length][matrix[0].length];
            
            for (int i = 0; i < maxGroup; i++) {
                int size = integerToPoint[i].size();
                for (int j = 0; j < size; j++) {
                    Point p = integerToPoint[i].get(j);
                    Point pNew = integerToPoint[i].get((j+nShifts)%size);
                    result[p.x][p.y] = matrix[pNew.x][pNew.y];
                }
            }
            printMatrix(result);
        }
    }

    private static class Point {

        public final int y;
        public final int x;
        private final int hash;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.hash = (x + "-" + y).hashCode();
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.y != other.y) {
                return false;
            }
            if (this.x != other.x) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

    }
}
