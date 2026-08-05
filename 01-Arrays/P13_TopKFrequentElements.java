import java.util.HashMap;
import java.util.PriorityQueue;

public class P13_TopKFrequentElements {

    /*
     * LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
     *
     * Problem:
     * Return the k most frequent elements in the array.
     *
     * Input:  nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     * Input:  nums = [1], k = 1
     * Output: [1]
     *
     * Approach:
     * Count the frequency using HashMap.
     * Maintain a Min Heap of size k.
     * Remove the least frequent element when
     * the heap size exceeds k.
     *
     * Time: O(n log k)
     * Space: O(n)
     */

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {

            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}