package us.vicentini.hackerrank.skillsverification.javabasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void fizzBuzz(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            System.out.println(printFizzBuzz(i));
        }

    }


    static String printFizzBuzz(int i) {
        boolean is3 = i % 3 == 0;
        boolean is5 = i % 5 == 0;
        StringBuilder sb = new StringBuilder();
        if (!is3 && !is5) {
            sb.append(i);
        } else {
            if (is3) {
                sb.append("Fizz");
            }
            if (is5) {
                sb.append("Buzz");
            }
        }
        return sb.toString();
    }

}


public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
