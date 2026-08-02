public class P02_LinkedListCycleII {

    /*
     * LeetCode: https://leetcode.com/problems/linked-list-cycle-ii/
     *
     * Problem:
     * Return the node where the cycle begins.
     * If there is no cycle, return null.
     *
     * Input:  head = [3,2,0,-4], pos = 1
     * Output: Node with value 2
     *
     * Input:  head = [1,2], pos = -1
     * Output: null
     *
     * Approach:
     * Use Floyd's Cycle Detection.
     * Find the meeting point of slow and fast pointers.
     * Move slow to head and advance both one step.
     * The node where they meet is the start of the cycle.
     *
     * Time: O(n)
     * Space: O(1)
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}