package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bear-and-workbook
 * https://www.hackerrank.com/challenges/bear-and-workbook/submissions/code/23251376
 * 
 * 
 * Sample Input
 * 5 3  
 * 4 2 6 1 10
 * 
 * Sample Output
 * 4
 * 
 * @author Shulander
 */
public class LisasWorkbook {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int chapters = myScan.nextInt();
        float exercisesPP = myScan.nextInt();
        int page = 1;
        int result = 0;
        for (int i = 1; i <= chapters; i++) {
            int excercies = myScan.nextInt();
            int pages = (int) Math.round((excercies / exercisesPP) + 0.4999);
            for (int j = 0; j < pages; j++) {
                float ini = (j * exercisesPP + 1);
                float end = ((j + 1) * exercisesPP);
                if (end > excercies) {
                    end = excercies;
                }
                if ((page + j) >= ini
                        && (page + j) <= end) {
                    result++;
                }
            }
            page += pages;
        }
        System.out.println(result);
    }
}
