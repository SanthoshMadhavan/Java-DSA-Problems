public class P02_FindFirstAndLastPosition {

    /*
     * LeetCode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * Problem:
     * Find the first and last position of target in a sorted array.
     * Return [-1,-1] if target is not present.
     *
     * Input:  nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     *
     * Input:  nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     *
     * Approach:
     * Use Binary Search twice.
     * For first occurrence, move high left after finding target.
     * For last occurrence, move low right after finding target.
     *
     * Time: O(log n)
     * Space: O(1)
     */

    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);

        return new int[]{first, last};
    }

    public int firstOccurrence(int[] nums, int target) {

        int ans = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int lastOccurrence(int[] nums, int target) {

        int ans = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}