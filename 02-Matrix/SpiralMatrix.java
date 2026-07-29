import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {
    /*
     * LeetCode: https://leetcode.com/problems/spiral-matrix/
     *
     * Problem:
     * Return all elements of a matrix in spiral order.
     *
     * Input:  [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * Input:  [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * Approach:
     * Use four boundaries: top, bottom, left, right.
     * Traverse: top row → right column → bottom row → left column.
     * Shrink the boundaries after each traversal.
     *
     * Time: O(m * n)
     * Space: O(m * n) for the result list.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Top row
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            // Right column
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            // Bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}