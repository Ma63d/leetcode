/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode runner = fakeHead;
        while(l1!= null || l2 != null){
            if (l1 == null) {
               runner.next = l2;
               break;
            }else if(l2 == null){
                runner.next = l1;
                break;
            }
            runner.next = l1;
            l1.val +=l2.val;
            l1 = l1.next;
            l2 = l2.next;
            runner = runner.next;
        }
        runner = fakeHead.next;
        int update = 0;
        ListNode prev = fakeHead;
        while(runner != null){
            runner.val +=update;
            update = runner.val/10;
            runner.val %= 10;
            runner= runner.next;
            prev = prev.next;
        }
        if(update != 0){
            prev.next = new ListNode(update);
        }
        return fakeHead.next;
    }
}