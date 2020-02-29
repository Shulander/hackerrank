package us.vicentini.amazon;

/**
 *
 * @author Shulander
 */
public class Problem2 {

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
    }

    public static int bestProfit(int[] priceHistory) {

        int profit = -1;
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
                int aux = priceHistory[j] - priceHistory[i];
                if (aux > profit) {
                    profit = aux;
                }
            }
            i = j + 1;
        }

        return profit;
    }
}
