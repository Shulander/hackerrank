package us.vicentini.hackerrank.algorithms;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 * https://www.hackerrank.com/challenges/cavity-map/submissions/code/23250560
 * 
 * Sample Input 
 * 4
 * 1112
 * 1912
 * 1892
 * 1234
 * 
 * Sample Output 
 * 1112
 * 1X12
 * 18X2
 * 1234
 * 
 * @author Shulander
 */
public class CavityMap {

    public static void main(String[] args) throws InterruptedException {
        Scanner myScan = new Scanner(System.in);
        int matrixSize = myScan.nextInt();
        char[][] original = new char[matrixSize][matrixSize];
        char[][] solution = new char[matrixSize][matrixSize];

        myScan.nextLine();
        for (int i = 0; i < matrixSize; i++) {
            String line = myScan.nextLine();
            original[i] = line.toCharArray();
            solution[i] = line.toCharArray();
        }

        for (int i = 1; i < matrixSize - 1; i++) {
            for (int j = 1; j < matrixSize - 1; j++) {
                if ((original[i][j] > original[i - 1][j]) && (original[i][j] > original[i][j + 1])
                        && (original[i][j] > original[i + 1][j]) && (original[i][j] > original[i][j - 1])) {
                    solution[i][j] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                sb.append(solution[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
