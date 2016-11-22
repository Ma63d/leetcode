# -*- coding:utf-8 -*-


# Follow up for problem "Populating Next Right Pointers in Each Node".
# What if the given tree could be any binary tree? Would your previous solution still work?
#
# Note:
# You may only use constant extra space.
#
#
# For example,
# Given the following binary tree,
#
#          1
#        /  \
#       2    3
#      / \    \
#     4   5    7
#
#
#
# After calling your function, the tree should look like:
#
#          1 -> NULL
#        /  \
#       2 -> 3 -> NULL
#      / \    \
#     4-> 5 -> 7 -> NULL


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root!=null){
            TreeLinkNode head = null,last = null;
            while(root != null){
                if(root.left != null){
                    if(head == null) head = last = root.left;
                    else {
                        last.next = root.left;
                        last = root.left;
                    }
                }
                if(root.right != null){
                    if(head == null) head = last = root.right;
                    else {
                        last.next = root.right;
                        last = root.right;
                    }
                }
                root = root.next;   
            }
            root = head;
        }
    }
}
