# -*- coding:utf-8 -*-


# Reverse a linked list from position m to n. Do it in-place and in one-pass.
#
#
#
# For example:
# Given 1->2->3->4->5->NULL, m = 2 and n = 4,
#
#
# return 1->4->3->2->5->NULL.
#
#
# Note:
# Given m, n satisfy the following condition:
# 1 ≤ m ≤ n ≤ length of list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        ListNode cur = prev.next = head;
        for(int i = 1;i < m;i++,cur = cur.next,prev = prev.next);
        for(int i = m;i < n;i++){
            ListNode reverseHead = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = reverseHead;
        }
        return fakeHead.next;
    }
}
