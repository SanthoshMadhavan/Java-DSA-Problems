import java.util.HashMap;

public class P11_ContiguousArray {

    /*
     * LeetCode: https://leetcode.com/problems/contiguous-array/
     *
     * Problem:
     * Find the maximum length of a contiguous subarray
     * with an equal number of 0's and 1's.
     *
     * Input:  [0,1]
     * Output: 2
     *
     * Input:  [0,1,0]
     * Output: 2
     *
     * Approach:
     * Treat 0 as -1 and 1 as +1.
     * Store the first occurrence of each prefix sum.
     * If the same prefix sum appears again,
     * the subarray between them has equal 0's and 1's.
     *
     * Time: O(n)
     * Space: O(n)
     */

    public int findMaxLength(int[] nums) {

        int preSum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            preSum += (nums[i] == 0) ? -1 : 1;

            if (preSum == 0) {
                res = i + 1;
            }

            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }

        return res;
    }
}