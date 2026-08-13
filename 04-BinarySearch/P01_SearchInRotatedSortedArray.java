public class P01_SearchInRotatedSortedArray {

    /*
     * LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * Problem:
     * Search for target in a rotated sorted array.
     * Return its index, or -1 if not found.
     *
     * Input:  nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * Input:  nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     *
     * Approach:
     * Use modified Binary Search.
     * At every step, one half is always sorted.
     * Check whether target lies in the sorted half.
     *
     * Time: O(log n)
     * Space: O(1)
     */

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                // Right half is sorted
            } else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}