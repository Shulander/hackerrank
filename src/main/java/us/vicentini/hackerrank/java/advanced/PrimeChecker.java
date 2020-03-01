package us.vicentini.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;


class Prime {
    public void checkPrime(int... values) {
        StringBuilder sb = new StringBuilder();
        for (int value : values) {
            if (BigInteger.valueOf(value).isProbablePrime(1)) {
                sb.append(value).append(" ");
            }
        }
        System.out.println(sb);
    }
}


public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static class PrimeJava8 {
        public void checkPrime(int... n1) {
            Arrays.stream(n1)
                    .filter(value -> BigInteger.valueOf(value).isProbablePrime(1))
                    .mapToObj(operand -> operand + " ")
                    .reduce((s, s2) -> s + s2)
                    .ifPresent(System.out::println);
        }
    }
}

