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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(10);
        ListNode lp = less;
        ListNode grat = new ListNode(10);
        ListNode gp = grat;
        while (head != null) {
            if (head.val < x) {
                lp.next = head;
                lp = lp.next;
            } else {
                gp.next = head;
                gp = gp.next;
            }
            head = head.next;
        }
        lp.next = grat.next;
        gp.next = null;
        return less.next;
    }
}