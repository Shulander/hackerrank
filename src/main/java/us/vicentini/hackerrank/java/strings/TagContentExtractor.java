package us.vicentini.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
        while (testCases-- > 0) {
            String line = in.nextLine();

            Matcher m = p.matcher(line);

            // Check for subsequences of input that match the compiled pattern
            StringBuilder result = new StringBuilder();
            while (m.find()) {
                result.append(m.group(2)).append("\n");
            }

            if (result.length() == 0) {
                result.append("None\n");
            }

            // Prints the modified sentence.
            System.out.print(result);
        }
    }
}
