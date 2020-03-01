package us.vicentini.hackerrank.algorithms.strings;


import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strong-password/problem
 *
 * @author Shulander
 */
public class StrongPassword {
    private static final String NUMBERS = "0123456789";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";


    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int evaluation = 4;
        boolean hasNumber = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (!hasNumber && NUMBERS.contains(String.valueOf(c))) {
                hasNumber = true;
                evaluation--;
            } else if (!hasLowerCase && LOWER_CASE.contains(String.valueOf(c))) {
                hasLowerCase = true;
                evaluation--;
            } else if (!hasUpperCase && UPPER_CASE.contains(String.valueOf(c))) {
                hasUpperCase = true;
                evaluation--;
            } else if (!hasSpecialChar && SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialChar = true;
                evaluation--;
            }
        }
        return Math.max(Math.max(6 - n, 0), evaluation);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);

        scanner.close();
    }
}
