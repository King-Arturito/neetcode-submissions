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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = head;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = null;
        ListNode reverse = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = next;
        }

        while (head != null && reverse != null) {
            ListNode headNext = head.next;
            ListNode reverseNext = reverse.next;

            head.next = reverse;
            if (headNext != null) {
                reverse.next = headNext;
            }
            
            head = headNext;
            reverse = reverseNext;
        }
    }

}