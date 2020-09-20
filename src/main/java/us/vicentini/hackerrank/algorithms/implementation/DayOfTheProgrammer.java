package us.vicentini.hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int day = 13;
        if (year == 1918) {
            return "26.09.1918";
        } else if (year > 1918) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                day--;
            }
        } else {
            if (year % 4 == 0) {
                day--;
            }
        }
        return day + ".09." + year;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);
        bufferedReader.close();
    }
}
