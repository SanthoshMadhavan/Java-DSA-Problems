public class P09_MaximumSumSubarrayOfSizeK {

    /*
     * GeeksforGeeks:
     * https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
     *
     * Problem:
     * Find the maximum sum of any subarray
     * of size k.
     *
     * Input:  arr = [100, 200, 300, 400], k = 2
     * Output: 700
     *
     * Input:  arr = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
     * Output: 39
     *
     * Approach:
     * Calculate the first window sum.
     * Slide the window by adding the new element
     * and removing the leftmost element.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
        }
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        for (int i = k; i < n; i++) {

            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}