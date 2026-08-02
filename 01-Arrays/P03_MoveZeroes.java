public class P03_MoveZeroes {

    /*
     * LeetCode: https://leetcode.com/problems/move-zeroes/
     *
     * Problem:
     * Move all zeroes to the end while maintaining
     * the relative order of non-zero elements.
     *
     * Input:  [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * Input:  [1,0,2,0,3]
     * Output: [1,2,3,0,0]
     *
     * Approach:
     * k points to the position for the next non-zero.
     * First move all non-zero elements to the front,
     * then fill the remaining positions with zeroes.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[k++] = nums[i];
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}