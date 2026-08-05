import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12_ThreeSum {

    /*
     * LeetCode: https://leetcode.com/problems/3sum/
     *
     * Problem:
     * Find all unique triplets whose sum is 0.
     *
     * Input:  [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * Input:  [0,1,1]
     * Output: []
     *
     * Approach:
     * Sort the array.
     * Fix one element and use two pointers
     * to find the remaining two elements.
     * Skip duplicate values.
     *
     * Time: O(n²)
     * Space: O(1) (excluding output)
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}