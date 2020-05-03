package us.vicentini.hackerrank.java.advanced;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Shulander
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {

    String userRole() default "GUEST";

    int budgetLimit() default 100;
}


class FamilyMember {

    @FamilyBudget(budgetLimit = 100, userRole = "SENIOR")
    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }


    @FamilyBudget(budgetLimit = 50, userRole = "JUNIOR")
    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}


public class Annotations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String role = in.next();
            int spend = in.nextInt();
            try {
                Class<FamilyMember> annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    checkBudget(method, role, spend);
                }
            } catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            testCases--;
        }
    }


    private static void checkBudget(Method method, String role, int spend)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (method.isAnnotationPresent(FamilyBudget.class)) {
            FamilyBudget family = method.getAnnotation(FamilyBudget.class);
            String userRole = family.userRole();
            int budgetLimit = family.budgetLimit();
            if (userRole.equals(role)) {
                if (spend <= budgetLimit) {
                    method.invoke(FamilyMember.class.getDeclaredConstructor().newInstance(), budgetLimit, spend);
                } else {
                    System.out.println("Budget Limit Over");
                }
            }
        }
    }
}
