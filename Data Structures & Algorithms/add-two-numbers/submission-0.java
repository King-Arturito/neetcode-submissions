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
        ListNode tail = dummy;
        int remainder = 0;

        while (l1 != null && l2 != null) {
            int add = l1.val + l2.val + remainder;
            remainder = add/10;
            ListNode res = new ListNode(add%10);
            tail.next = res;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int add = l1.val + remainder;
            remainder = add/10;
            ListNode res = new ListNode(add%10);
            tail.next = res;
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int add = l2.val + remainder;
            remainder = add/10;
            ListNode res = new ListNode(add%10);
            tail.next = res;
            tail = tail.next;
            l2 = l2.next;
        }


        if (remainder == 1) {
            ListNode n = new ListNode(1);
            tail.next = n;
        }
        return dummy.next;
    }
}

//9,9,9
//9,9,9,9,9,9,9,9,9
//8,9,9,0,0,0,0,0,1
//99999999
//     999
//=
//100000998