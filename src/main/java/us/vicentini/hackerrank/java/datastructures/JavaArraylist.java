package us.vicentini.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nLines = myScan.nextInt();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>(nLines);
        for (int i = 0; i < nLines; i++) {
            data.add(readArrayList(myScan));
        }

        int nTests = myScan.nextInt();
        while (nTests-- > 0) {
            int row = myScan.nextInt() - 1;
            int collumn = myScan.nextInt() - 1;
            try {
                System.out.println(data.get(row).get(collumn));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }


    private static ArrayList<Integer> readArrayList(Scanner myScan) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int nRows = myScan.nextInt();
        while (nRows-- > 0) {
            result.add(myScan.nextInt());
        }

        return result;
    }
}
