# -*- coding:utf-8 -*-


# Write a program to find the node at which the intersection of two singly linked lists begins.
#
# For example, the following two linked lists: 
#
# A:          a1 → a2
#                    ↘
#                      c1 → c2 → c3
#                    ↗            
# B:     b1 → b2 → b3
#
# begin to intersect at node c1.
#
# Notes:
#
# If the two linked lists have no intersection at all, return null.
# The linked lists must retain their original structure after the function returns. 
# You may assume there are no cycles anywhere in the entire linked structure.
# Your code should preferably run in O(n) time and use only O(1) memory.
#
#
#
# Credits:Special thanks to @stellari for adding this problem and creating all test cases.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 1;
        int lenB = 1;
        ListNode runnerA = headA,runnerB = headB;
        while(runnerA.next != null){
            runnerA = runnerA.next;
            lenA++;
        }
        while(runnerB.next != null){
            runnerB = runnerB.next;
            lenB++;
        }
        if(runnerA != runnerB){
            return null;
        }
        runnerA = headA;runnerB = headB;
        if(lenA > lenB){
            while(lenA > lenB){
                lenA--;
                runnerA = runnerA.next;
            }
        }
        if(lenA < lenB){
            while(lenA < lenB){
                lenB--;
                runnerB = runnerB.next;
            }
        }
        while(runnerA != runnerB){
            runnerA = runnerA.next;
            runnerB = runnerB.next;
        }
        return runnerA;
    }
}
