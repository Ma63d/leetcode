# -*- coding:utf-8 -*-


# Given a linked list, remove the nth node from the end of list and return its head.
#
#
# For example,
#
#
#    Given linked list: 1->2->3->4->5, and n = 2.
#
#    After removing the second node from the end, the linked list becomes 1->2->3->5.
#
#
#
# Note:
# Given n will always be valid.
# Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode NAfter = head;
        ListNode beforeNAfter = head;
        int len = 1;
        while(n > 1){
            front = front.next;
            len++;
            n--;
        }
        if(front.next == null){
            return head.next;
        }else{
            while(front.next != null){
                beforeNAfter = NAfter;
                front = front.next;
                NAfter = NAfter.next;
            }
            beforeNAfter.next = NAfter.next;
            return head;
        }
    }
}
