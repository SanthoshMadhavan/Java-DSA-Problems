public class P03_FindPeakElement {

    /*
     * LeetCode: https://leetcode.com/problems/find-peak-element/
     *
     * Problem:
     * Find a peak element and return its index.
     * A peak is greater than its neighbors.
     *
     * Input:  nums = [1,2,3,1]
     * Output: 2
     *
     * Input:  nums = [1,2,1,3,5,6,4]
     * Output: 5
     *
     * Approach:
     * Use Binary Search.
     * If nums[mid] < nums[mid + 1], a peak exists on the right.
     * Otherwise, a peak exists on the left or at mid.
     *
     * Time: O(log n)
     * Space: O(1)
     */

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] &&
                    nums[mid] > nums[mid + 1]) {

                return mid;

            } else if (nums[mid] < nums[mid + 1]) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return 0;
    }
}