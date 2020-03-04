package us.vicentini.hackerrank.java.strings;

import java.util.Scanner;

public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        byte[] aByteArrays = a.toLowerCase().getBytes();
        java.util.Arrays.sort(aByteArrays);
        String aSorted = new String(aByteArrays);
        byte[] bByteArrays = b.toLowerCase().getBytes();
        java.util.Arrays.sort(bByteArrays);
        String bSorted = new String(bByteArrays);
        return aSorted.equals(bSorted);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
