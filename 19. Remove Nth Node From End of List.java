/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode t = head;
        while (t != null) {
            l++;
            t = t.next;
        }
        l -= n;

        if (l == 0) {
            return head.next;
        }
        l--;
        t = head;
        while (l-- > 0) {
            t = t.next;
        }
        t.next = t.next.next;
        return head;
    }
}