package us.vicentini.hackerrank.java.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a / b);
        } catch (InputMismatchException ex) {
            System.out.println(ex.getClass().getName());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
