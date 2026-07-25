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
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = reverse;
            reverse = curr;
            curr = next;
        }
        return reverse;
    }
    // 0 
    // 0 -> 1 -> 2 -> 3 -> null
    // 3 -> 2 -> 1 -> 0 -> null
}
