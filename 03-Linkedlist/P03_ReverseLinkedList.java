public class P03_ReverseLinkedList {

    /*
     * LeetCode: https://leetcode.com/problems/reverse-linked-list/
     *
     * Problem:
     * Reverse a singly linked list.
     *
     * Input:  1 -> 2 -> 3 -> 4 -> 5
     * Output: 5 -> 4 -> 3 -> 2 -> 1
     *
     * Input:  1 -> 2
     * Output: 2 -> 1
     *
     * Approach:
     * Use prev, curr and next pointers.
     * Reverse each link while moving forward.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}