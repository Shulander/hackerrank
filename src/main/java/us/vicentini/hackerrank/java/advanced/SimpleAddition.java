package us.vicentini.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/simple-addition-varargs
 * https://www.hackerrank.com/challenges/simple-addition-varargs/submissions/code/21557566
 * 
 * Sample Input
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 
 * Sample Output
 * 1+2=3
 * 1+2+3=6
 * 1+2+3+4+5=15
 * 1+2+3+4+5+6=21
 * 
 * @author Shulander
 */
public class SimpleAddition {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);
            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Add {
    public void add(int firstNumber, int... otherNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstNumber);
        int total = firstNumber;
        for (int number : otherNumbers) {
            sb.append('+').append(number);
            total += number;
        }
        sb.append('=').append(total);
        System.out.println(sb.toString());
    }
}