public class P16_MergeSortedArray {

    /*
     * LeetCode: https://leetcode.com/problems/merge-sorted-array/
     *
     * Problem:
     * Merge nums2 into nums1 in sorted order.
     * nums1 has enough space to hold both arrays.
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     *
     * Input:
     * nums1 = [1], m = 1
     * nums2 = [], n = 0
     * Output: [1]
     *
     * Approach:
     * Start from the end of both arrays.
     * Put the larger element at the end of nums1.
     * This avoids overwriting existing elements.
     *
     * Time: O(m + n)
     * Space: O(1)
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}