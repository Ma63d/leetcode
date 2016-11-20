# -*- coding:utf-8 -*-


# Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
#
#
# For example,
# Given 1->2->3->3->4->4->5, return 1->2->5.
# Given 1->1->1->2->3, return 2->3.


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
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int cur = head.next.val;
                ListNode curNode = head.next;
                while(curNode != null && curNode.val == cur){
                    curNode = curNode.next;
                }
                head.next = curNode;
            }else{
                head = head.next;
            }
        }
        return fakeHead.next;
    }
}
