# -*- coding:utf-8 -*-


# Given a list, rotate the list to the right by k places, where k is non-negative.
#
# For example:
# Given 1->2->3->4->5->NULL and k = 2,
# return 4->5->1->2->3->NULL.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode runner = head,catcher=head,catcherFather=head;
        
        int len = 1;
        for(;runner.next!=null;len++) runner = runner.next;
        k = k % len;
        if(k == 0) return head;
        runner = head;
        for(int i = 1; i < k;i++){
            if(runner.next != null){
                runner = runner.next;
            }else{
                return head;
            }
        }
        while(runner.next != null){
            runner = runner.next;
            catcherFather = catcher;
            catcher = catcher.next;
        }
        catcherFather.next = null;
        runner.next = head;
        return catcher;
    }
}
