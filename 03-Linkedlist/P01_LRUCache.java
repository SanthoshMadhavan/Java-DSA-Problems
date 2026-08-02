import java.util.LinkedHashMap;

public class P01_LRUCache {

    /*
     * LeetCode: https://leetcode.com/problems/lru-cache/
     *
     * Problem:
     * Design an LRU (Least Recently Used) Cache
     * supporting get() and put() in O(1).
     *
     * Input:
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     *
     * Output:
     * [null,null,null,1,null,-1,null,-1,3,4]
     *
     * Approach:
     * Use LinkedHashMap with accessOrder = true.
     * Recently accessed entries move to the end.
     * When capacity exceeds the limit,
     * remove the first key (Least Recently Used).
     *
     * Time:
     * get()  -> O(1)
     * put()  -> O(1)
     *
     * Space: O(capacity)
     */

    class LRUCache {

        int capacity;
        LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            return map.get(key);
        }

        public void put(int key, int value) {

            map.put(key, value);

            if (map.size() > capacity) {

                int lru = map.keySet().iterator().next();
                map.remove(lru);
            }
        }
    }
}