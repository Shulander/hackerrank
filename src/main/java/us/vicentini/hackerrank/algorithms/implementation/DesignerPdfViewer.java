package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class DesignerPdfViewer {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = 0;
        for (char c : word.toCharArray()) {
            int height = h[c - 'a'];
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return word.length() * maxHeight;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);
        System.out.println(result);

        scanner.close();
    }
}

