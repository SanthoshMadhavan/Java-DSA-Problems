public class SortColors {
    /*
     * LeetCode: https://leetcode.com/problems/sort-colors/
     *
     * Problem:
     * Sort an array containing 0, 1, and 2 in-place.
     *
     * Input:  [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     *
     * Input:  [2,0,1]
     * Output: [0,1,2]
     *
     * Approach:
     * Use three pointers: lo, mid, and hi.
     * lo -> position for 0
     * mid -> current element
     * hi -> position for 2
     *
     * 0: swap with lo, move lo and mid
     * 1: move mid
     * 2: swap with hi, move hi only
     *
     * Time: O(n)
     * Space: O(1)
     */

    public void sortColors(int[] nums) {

        int lo = 0;
        int mid = 0;
        int hi = nums.length - 1;

        while (mid <= hi) {

            if (nums[mid] == 0) {
                int temp = nums[lo];
                nums[lo++] = nums[mid];
                nums[mid++] = temp;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[hi];
                nums[hi--] = nums[mid];
                nums[mid] = temp;
            }
        }
    }
}