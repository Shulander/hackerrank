package us.vicentini.hackerrank.java.datastructure;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int nLines = myScan.nextInt();
        LinkedList<Integer> data = new LinkedList<>();
        for (int i = 0; i < nLines; i++) {
            data.add(myScan.nextInt());
        }
        int nModifications = myScan.nextInt();
        while (nModifications-- > 0) {
            processCommand(myScan, data);
        }

        String output = data.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }


    private static void processCommand(Scanner myScan, LinkedList<Integer> data) {
        String command = myScan.next();
        int position = myScan.nextInt();
        if ("Insert".equals(command)) {
            int value = myScan.nextInt();
            data.add(position, value);
        } else if ("Delete".equals(command)) {
            data.remove(position);
        }
    }
}

