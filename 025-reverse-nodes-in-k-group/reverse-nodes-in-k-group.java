# -*- coding:utf-8 -*-


# Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
#
#
#
# If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
#
# You may not alter the values in the nodes, only nodes itself may be changed.
#
# Only constant memory is allowed.
#
#
# For example,
# Given this linked list: 1->2->3->4->5
#
#
#
# For k = 2, you should return: 2->1->4->3->5
#
#
#
# For k = 3, you should return: 3->2->1->4->5


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2){
            return head;
        }
        return reverseKOneTime(head,k);
    }
    private ListNode reverseKOneTime(ListNode head, int k){
        int i = 0;
        for(ListNode temp = head;temp != null && i < k;i++,temp=temp.next);
        if(i == k){
            ListNode start = head, end = head;
            for(i = 0;i < k-1;i++){
                ListNode temp = end.next;
                end.next = temp.next;
                temp.next = start;
                start = temp;
            }
            end.next = reverseKOneTime(end.next,k);
            head = start;
        }
        return head;
    }
}
