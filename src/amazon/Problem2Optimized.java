package amazon;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Shulander
 */
public class Problem2Optimized {

    public static void main(String[] args) {
        System.out.println("teste");
        int[] array = {2, 3, 5, 1, 2, 6, 5};
        System.out.println(bestProfit(array));
        int[] array2 = {10, 8, 7, 5, 3, 6, 7, 6, 4, 6};
        System.out.println(bestProfit(array2));
        int[] array3 = {10, 8, 7, 5, 3};
        System.out.println(bestProfit(array3));
        int[] array4 = {10};
        System.out.println(bestProfit(array4));
        int[] array5 = {10, 8, 7, 5, 3, 6, 7, 6, 4, 6, 8};
        System.out.println(bestProfit(array5));
    }

    public static int bestProfit(int[] priceHistory) {

        int profit = -1;

        int[] valleysAndPeaks = createArrayValleysAndPeaks(priceHistory);
        if (valleysAndPeaks == null || valleysAndPeaks.length < 2) {
            return profit;
        }

        for (int i = 0; i < valleysAndPeaks.length; i += 2) {
            int valley = priceHistory[valleysAndPeaks[i]];
            for (int j = i + 1; j < valleysAndPeaks.length; j += 2) {
                int peak = priceHistory[valleysAndPeaks[j]];
                if ((peak - valley) > profit) {
                    profit = (peak - valley);
                }
            }
        }

        return profit;
    }

    public static int[] createArrayValleysAndPeaks(int[] priceHistory) {

        List<Integer> valleysAndPeaks = new LinkedList<>();
        // lower index
        int i = 0;
        // higher index
        int j = 0;

        while (j < priceHistory.length && i < priceHistory.length) {
            // find lower price
            while (i + 1 < priceHistory.length && priceHistory[i] > priceHistory[i + 1]) {
                i++;
            }
            // find next max price
            j = i + 1;
            while (j + 1 < priceHistory.length && priceHistory[j] < priceHistory[j + 1]) {
                j++;
            }

            // check if any index got to the end
            // case not calculate the new profit value
            if (j < priceHistory.length && i < priceHistory.length) {
                valleysAndPeaks.add(i);
                valleysAndPeaks.add(j);
            }
            i = j + 1;
        }
        if (valleysAndPeaks.isEmpty()) {
            return null;
        }
        int[] returnValue = new int[valleysAndPeaks.size()];

        int k = 0;
        for (Integer valleysAndPeak : valleysAndPeaks) {
            returnValue[k++] = valleysAndPeak;
        }

        return returnValue;
    }
}
