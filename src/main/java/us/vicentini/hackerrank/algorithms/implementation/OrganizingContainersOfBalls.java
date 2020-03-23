package us.vicentini.hackerrank.algorithms.implementation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        Map<Integer, Integer> containerSizes = new LinkedHashMap<>(container.length);
        Map<Integer, Integer> typesCount = new LinkedHashMap<>(container.length);
        for (int i = 0; i < container.length; i++) {
            typesCount.put(i, 0);
            containerSizes.put(i, 0);
        }
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[i].length; j++) {
                typesCount.put(j, typesCount.get(j) + container[i][j]);
                containerSizes.put(i, containerSizes.get(i) + container[i][j]);
            }
        }

        Collection<Integer> containerSizeCollection = containerSizes.values();
        for (Integer value : typesCount.values()) {
            if (!containerSizeCollection.remove(value)) {
                return "Impossible";
            }
        }

        return containerSizeCollection.isEmpty() ? "Possible" : "Impossible";
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println(result);
        }

        scanner.close();
    }
}

