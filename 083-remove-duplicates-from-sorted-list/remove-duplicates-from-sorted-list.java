# -*- coding:utf-8 -*-


# Given a sorted linked list, delete all duplicates such that each element appear only once.
#
#
# For example,
# Given 1->1->2, return 1->2.
# Given 1->1->2->3->3, return 1->2->3.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = head;
        ListNode prev = head;
        while(head!= null && head.next != null){
            if(head.val == head.next.val){
                int cur = head.val;
                while(head != null && head.val == cur){
                    head = head.next;
                }
                prev.next = head;
                prev = head;
            }else{
                prev = head = head.next;    
            }
            
        }
        return start;
    }
}
