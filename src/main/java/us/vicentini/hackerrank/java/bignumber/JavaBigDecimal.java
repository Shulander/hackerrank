package us.vicentini.hackerrank.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class JavaBigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, (o1, o2) -> {
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            BigDecimal bd1 = new BigDecimal(o1);
            BigDecimal bd2 = new BigDecimal(o2);
            return bd2.compareTo(bd1);
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
