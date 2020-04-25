package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        double sqrt = Math.sqrt(s.length());
        int r = (int) Math.floor(sqrt);
        int c = (int) Math.ceil(sqrt);
        if (c * r < s.length()) {
            r++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                int pos = j * c + i;
                if (pos < s.length()) {
                    char c1 = s.charAt(pos);
                    sb.append(c1);
                }
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);

        scanner.close();
    }
}
