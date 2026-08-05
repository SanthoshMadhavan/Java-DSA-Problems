import java.util.HashSet;

public class P14_IntersectionOfTwoArrays {

    /*
     * LeetCode: https://leetcode.com/problems/intersection-of-two-arrays/
     *
     * Problem:
     * Return the unique intersection of two arrays.
     *
     * Input:  nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     *
     * Input:  nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     *
     * Approach:
     * Store elements of the first array in a HashSet.
     * Traverse the second array and add common
     * elements to another HashSet.
     *
     * Time: O(n + m)
     * Space: O(n)
     */

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] res = new int[result.size()];
        int i = 0;

        for (int num : result) {
            res[i++] = num;
        }

        return res;
    }
}