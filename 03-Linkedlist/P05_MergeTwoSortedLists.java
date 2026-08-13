public class P05_MergeTwoSortedLists {

    /*
     * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
     *
     * Problem:
     * Merge two sorted linked lists into one sorted list.
     *
     * Input:  list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     *
     * Input:  list1 = [], list2 = [0]
     * Output: [0]
     *
     * Approach:
     * Use a dummy node and curr pointer.
     * Compare both nodes and attach the smaller one.
     * Attach the remaining nodes at the end.
     *
     * Time: O(n + m)
     * Space: O(1)
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}