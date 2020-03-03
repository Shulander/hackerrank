package us.vicentini.hackerrank.java.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] argh) {
        Map<String, Integer> data = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            data.put(name.trim(), phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phone = data.get(s.trim());
            if (phone == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phone);
            }
        }
    }
}
