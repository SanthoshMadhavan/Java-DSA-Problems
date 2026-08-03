public class P10_MinimumSizeSubarraySum {

    /*
     * LeetCode: https://leetcode.com/problems/minimum-size-subarray-sum/
     *
     * Problem:
     * Find the minimum length of a subarray
     * whose sum is greater than or equal to target.
     *
     * Input:  target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     *
     * Input:  target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Approach:
     * Use a variable sliding window.
     * Expand the window until sum >= target.
     * Then shrink the window to find the minimum length.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}