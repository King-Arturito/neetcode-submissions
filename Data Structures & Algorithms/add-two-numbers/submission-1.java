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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int remainder = 0;

        while (l1 != null || l2 != null || remainder != 0) {
            int curr = 0;
            if (l1 != null) {
                curr += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                curr += l2.val;
                l2 = l2.next;
            }

            if (remainder == 1) {
                curr += remainder;
            }
            remainder = curr/10;
            ListNode n = new ListNode(curr%10);
            ans.next = n;
            ans = ans.next;
            
        }
        return dummy.next;
    }
}
