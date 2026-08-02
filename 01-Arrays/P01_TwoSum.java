import java.util.HashMap;

public class P01_TwoSum {

    /*
     * LeetCode: https://leetcode.com/problems/two-sum/
     *
     * Problem:
     * Given nums and target, return indices of two numbers
     * whose sum equals target.
     *
     * Input:  nums = [2,7,11,15], target = 9
     * Output: [0,1]
     *
     * Input:  nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     * Approach:
     * Store number and index in HashMap.
     * For each number, check if target - nums[i] exists.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}