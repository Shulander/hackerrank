package us.vicentini.hackerrank.java.datastructures;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BitSet[] bitSets = new BitSet[2];
        bitSets[0] = new BitSet(n);
        bitSets[1] = new BitSet(n);

        int operations = scan.nextInt();
        while (operations-- > 0) {
            String op = scan.next();
            int arg1 = scan.nextInt();
            int arg2 = scan.nextInt();
            if ("AND".equals(op)) {
                bitSets[arg1 - 1].and(bitSets[arg2 - 1]);
            } else if ("OR".equals(op)) {
                bitSets[arg1 - 1].or(bitSets[arg2 - 1]);
            } else if ("XOR".equals(op)) {
                bitSets[arg1 - 1].xor(bitSets[arg2 - 1]);
            } else if ("FLIP".equals(op)) {
                bitSets[arg1 - 1].flip(arg2);
            } else if ("SET".equals(op)) {
                bitSets[arg1 - 1].set(arg2);
            }
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
