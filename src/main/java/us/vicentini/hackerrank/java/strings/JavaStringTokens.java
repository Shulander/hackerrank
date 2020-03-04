package us.vicentini.hackerrank.java.strings;

import java.util.Scanner;

public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String trimmedStr = s.trim();
        if (trimmedStr.length() == 0) {
            System.out.println("0");
        } else {
            String[] result = trimmedStr.split("[ !,?._'@]+");
            System.out.println(result.length);
            for (String token : result) {
                System.out.println(token);
            }
        }
        scan.close();
    }
}
