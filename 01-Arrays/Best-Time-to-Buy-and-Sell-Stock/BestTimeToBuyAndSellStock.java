public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            minPrice = Math.min(prices[i], minPrice);

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}