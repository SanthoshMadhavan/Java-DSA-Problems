import java.util.HashSet;

public class P15_FindPairWithGivenDifference {

    /*
     * GeeksforGeeks:
     * https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
     *
     * Problem:
     * Check if there exists a pair with
     * absolute difference equal to x.
     *
     * Input:  arr = [5, 20, 3, 2, 5, 80], x = 78
     * Output: true
     *
     * Input:  arr = [90, 70, 20, 80, 50], x = 45
     * Output: false
     *
     * Approach:
     * Store visited elements in a HashSet.
     * For each element, check whether
     * (num + x) or (num - x) already exists.
     *
     * Time: O(n)
     * Space: O(n)
     */

    public boolean findPair(int[] arr, int x) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            if (set.contains(num + x) || set.contains(num - x)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}