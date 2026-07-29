public class RotateArray {

    /*
     * LeetCode: https://leetcode.com/problems/rotate-array/
     *
     * Problem:
     * Rotate the array to the right by k steps.
     *
     * Input:  nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     *
     * Input:  nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     *
     * Approach:
     * Reverse the entire array.
     * Reverse the first k elements.
     * Reverse the remaining elements.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}