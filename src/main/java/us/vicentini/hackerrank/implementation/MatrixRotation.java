/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.vicentini.hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
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
public class MatrixRotation {

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

        rotateMatrix(matrix, nShifts);
        printMatrix(matrix);
    }

    private static void rotateMatrix(int[][] matrix, int nShifts) {
        if (nShifts == 0) {
            return;
        }

        rotateMatrixImpl(matrix, 0);
        rotateMatrix(matrix, nShifts - 1);
    }

    private static void rotateMatrixImpl(int[][] matrix, int group) {
        if ((matrix.length / 2) <= group || (matrix[1].length / 2) <= group) {
            return;
        }

        int rows = matrix.length - group - 1;
        int colls = matrix[0].length - group - 1;

        int aux = matrix[group][group];
        int aux2 = matrix[rows][colls];

        int i = group;
        int j = group;
        for (; i < colls; i++) {
            matrix[j][i] = matrix[j][i + 1];
            matrix[rows + group - j][colls + group - i] = matrix[rows + group - j][colls + group - i - 1];
        }
        for (; j < rows; j++) {
            matrix[j][i] = matrix[j + 1][i];
            matrix[rows + group - j][colls + group - i] = matrix[rows + group - j - 1][colls + group - i];
        }
        matrix[group + 1][group] = aux;
        matrix[rows - 1][colls] = aux2;

        rotateMatrixImpl(matrix, group + 1);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
