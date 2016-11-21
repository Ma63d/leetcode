# -*- coding:utf-8 -*-


# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
#
#
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
#
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
#
#
#
# But the following [1,2,2,null,3,null,3]  is not:
#
#     1
#    / \
#   2   2
#    \   \
#    3    3
#
#
#
#
# Note:
# Bonus points if you could solve it both recursively and iteratively.


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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left == null){
            if(right == null){
                return true;
            }else{
                return false;
            }
        }else{
            if(right == null) return false;
            if(!dfs(left.left,right.right)) return false;
            if(left.val != right.val) return false;
            return dfs(left.right,right.left);
        }
        
    }
}
