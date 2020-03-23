package us.vicentini.hackerrank.algorithms.strings;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoTwo {


    public static final int SIZE = 5;


    /*
     * Complete the twoTwo function below.
     */
    static int twoTwo(String a) {
        int result = 0;


        Map<CharSequence, List<Integer>> idx = buildIdx(a);

        BigInteger strengthBI = BigInteger.ONE;
        for (int i = 0; i <= 800; i++) {
            String strength = strengthBI.toString();
            if (strength.length() > a.length()) {
                break;
            }
            result += countOccurrences(a, strength, idx);
            strengthBI = strengthBI.shiftLeft(1);
        }

        return result;
    }


    private static Map<CharSequence, List<Integer>> buildIdx(String a) {
        Map<CharSequence, List<Integer>> result = new HashMap<>();
        for (int i = 0; i <= a.length() - TwoTwo.SIZE; i++) {
            CharSequence idx = a.subSequence(i, i + TwoTwo.SIZE);
            if (!result.containsKey(idx)) {
                result.put(idx, new LinkedList<>());
            }
            result.get(idx).add(i);
        }
        return result;
    }


    private static int countOccurrences(String str, String strFind,
                                        Map<CharSequence, List<Integer>> idx) {
        if (strFind.length() < SIZE) {
            return countSubstringsUsingStringIndexOf(str, strFind);
        } else {
            return countSubstringsUsingPrecomputedIndexes(str, strFind, idx);
        }
    }


    private static int countSubstringsUsingPrecomputedIndexes(String str, String strFind,
                                                              Map<CharSequence, List<Integer>> idx) {
        int count = 0;
        CharSequence key = strFind.subSequence(0, SIZE);
        List<Integer> indexes = idx.getOrDefault(key, Collections.emptyList());
        for (Integer index : indexes) {
            CharSequence findSequence = strFind.subSequence(0, strFind.length());
            int endIndex = index + strFind.length();
            if (endIndex <= str.length() && findSequence.equals(str.subSequence(index, endIndex))) {
                count++;
            }
        }
        return count;
    }


    private static int countSubstringsUsingStringIndexOf(String str, String strFind) {
        int count = 0;
        int fromIndex = 0;


        while ((fromIndex = str.indexOf(strFind, fromIndex)) != -1) {
            count++;
            fromIndex++;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();

            int result = twoTwo(a);
            System.out.println(result);
        }
    }
}
