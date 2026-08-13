public class P04_MiddleOfTheLinkedList {

    /*
     * LeetCode: https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * Problem:
     * Return the middle node of a linked list.
     * For even length, return the second middle node.
     *
     * Input:  1 -> 2 -> 3 -> 4 -> 5
     * Output: 3
     *
     * Input:  1 -> 2 -> 3 -> 4 -> 5 -> 6
     * Output: 4
     *
     * Approach:
     * Use slow and fast pointers.
     * Slow moves one step and fast moves two steps.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}