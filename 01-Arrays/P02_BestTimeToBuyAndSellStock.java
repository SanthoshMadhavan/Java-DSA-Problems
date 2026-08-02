public class P02_BestTimeToBuyAndSellStock {

    /*
     * LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * Problem:
     * Find the maximum profit by buying on one day
     * and selling on a later day.
     *
     * Input:  [7,1,5,3,6,4]
     * Output: 5
     *
     * Input:  [7,6,4,3,1]
     * Output: 0
     *
     * Approach:
     * Keep track of the minimum price seen so far.
     * For each price, calculate the current profit
     * and keep the maximum profit.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int res = 0;
        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minSoFar = Math.min(prices[i], minSoFar);
            res = Math.max(res, prices[i] - minSoFar);
        }

        return res;
    }
}