public class P07_ContainerWithMostWater {

    /*
     * LeetCode: https://leetcode.com/problems/container-with-most-water/
     *
     * Problem:
     * Find two lines that together with the x-axis
     * form a container holding the maximum water.
     *
     * Input:  [1,8,6,2,5,4,8,3,7]
     * Output: 49
     *
     * Input:  [1,1]
     * Output: 1
     *
     * Approach:
     * Use two pointers.
     * Calculate the current area and move the pointer
     * with the smaller height.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}