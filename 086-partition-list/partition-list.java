# -*- coding:utf-8 -*-


# Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
#
#
# You should preserve the original relative order of the nodes in each of the two partitions.
#
#
# For example,
# Given 1->4->3->2->5->2 and x = 3,
# return 1->2->2->4->3->5.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode findLess = head,save = null;
        while(findLess != null){
            if(findLess.val < x){
                save = findLess;
            }
            findLess = findLess.next;
        }
        if(save == null){
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode tail = save;
        while(head != save){
            if(head.val >= x){
                ListNode cur = head.next;
                head.next = tail.next;
                prev.next = cur;
                tail.next = head;
                tail = head;
                head = cur;
            }else{
                prev = head;
                head = head.next;
            }
        }
        return fakeHead.next;
    }
}
