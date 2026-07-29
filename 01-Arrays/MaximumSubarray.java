public class MaximumSubarray {

    /*
     * LeetCode: https://leetcode.com/problems/maximum-subarray/
     *
     * Problem:
     * Find the contiguous subarray with the largest sum
     * and return its sum.
     *
     * Input:  [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     *
     * Input:  [5,4,-1,7,8]
     * Output: 23
     *
     * Approach:
     * Use Kadane's Algorithm.
     * maxEnding stores the maximum sum ending at current index.
     * At each element, either extend the subarray or start new.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int maxEnding = 0;

        for (int i = 0; i < n; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}