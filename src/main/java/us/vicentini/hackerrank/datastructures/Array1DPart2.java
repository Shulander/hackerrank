package us.vicentini.hackerrank.datastructures;

import java.util.*;


/**
 * https://www.hackerrank.com/challenges/java-1d-array
 * Sample Input
 * 4
 * 5 3
 * 0 0 0 0 0
 * 6 5
 * 0 0 0 1 1 1
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 * 
 * Sample Output
 * YES
 * YES
 * NO
 * NO
 * 
 * @author Shulander
 */
public class Array1DPart2 {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int nValues = myScan.nextInt();
            int[] arrayValues = new int[nValues];

            int mValue = myScan.nextInt();
            for (int i = 0; i < nValues; i++) {
                arrayValues[i] = myScan.nextInt();
            }

            CellphoneGame game = new CellphoneGame(arrayValues, mValue);
            System.out.println(game.process());
        }
    }

    private static class CellphoneGame {
        private final int[] values;
        private final boolean[] visitedArray;
        private final int startPosition;
        private final int jump;
        private CellphoneGame(int[] arrayValues, int mValue) {
            this.values = arrayValues;
            this.jump = mValue;
            this.startPosition = 0;
            this.visitedArray = new boolean[values.length];
        }
        
        public String process() {
            if(processImpl(startPosition)) {
                return "YES";
            } else {
                return "NO";
            }
        }

        private boolean processImpl(int position) {
            if(position >= values.length) {
                return true;
            } 
            if (position < 0 || visitedArray[position] || values[position]==1) {
                return false;
            }
            visitedArray[position] = true;
            
            if(processImpl(position-1)) {
                return true;
            } else if(processImpl(position+1)){
                return true;
            } else if(processImpl(position+jump)){
                return true;
            } else {
                return false;
            }
        }
    }

}
