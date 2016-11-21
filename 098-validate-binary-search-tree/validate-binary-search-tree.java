# -*- coding:utf-8 -*-


# Given a binary tree, determine if it is a valid binary search tree (BST).
#
#
#
# Assume a BST is defined as follows:
#
# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.
#
#
#
# Example 1:
#
#     2
#    / \
#   1   3
#
# Binary tree [2,1,3], return true.
#
#
# Example 2:
#
#     1
#    / \
#   2   3
#
# Binary tree [1,2,3], return false.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidSubTree(root,(double)Integer.MIN_VALUE,(double)Integer.MAX_VALUE);
    }
    public boolean isValidSubTree(TreeNode root,double start,double end){
        if(root == null) return true;
        if((double)(root.val) > end || (double)(root.val) < start) return false;
        if(!isValidSubTree(root.left,start,(double)(root.val)-1) || !isValidSubTree(root.right,(double)(root.val)+1,end)){
            return false;
        }
        return true;
    }
}
