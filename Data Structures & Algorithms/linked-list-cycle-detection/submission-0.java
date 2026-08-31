/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                //no cycle
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // slow and fast is in same node
                return true;
            } 
        }
    }
}
