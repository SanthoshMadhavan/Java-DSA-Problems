import java.util.HashMap;
import java.util.Map;

public class P08_LongestSubstringWithAtMostKDistinctCharacters {

    /*
     * LeetCode (Premium):
     * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
     *
     * Problem:
     * Find the length of the longest substring
     * containing at most k distinct characters.
     *
     * Input:  s = "eceba", k = 2
     * Output: 3
     *
     * Input:  s = "aa", k = 1
     * Output: 2
     *
     * Approach:
     * Use Sliding Window with a HashMap.
     * Expand the window by moving right.
     * If distinct characters exceed k,
     * shrink the window from the left.
     *
     * Time: O(n)
     * Space: O(k)
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}