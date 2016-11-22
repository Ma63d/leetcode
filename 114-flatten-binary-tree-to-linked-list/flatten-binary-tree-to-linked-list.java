# -*- coding:utf-8 -*-


# Given a binary tree, flatten it to a linked list in-place.
#
#
#
# For example,
# Given
#
#          1
#         / \
#        2   5
#       / \   \
#      3   4   6
#
#
#
# The flattened tree should look like:
#
#    1
#     \
#      2
#       \
#        3
#         \
#          4
#           \
#            5
#             \
#              6
#
#
# click to show hints.
#
# Hints:
# If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.


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
    public void flatten(TreeNode root) {
        if(root == null) return;
        _mergeLeftTree(root);
    }
    public TreeNode _mergeLeftTree(TreeNode root){
        if(root.left != null){
            TreeNode finalLeft = _mergeLeftTree(root.left);
            finalLeft.right = root.right;
            root.right = root.left;
            root.left = null;
            return finalLeft.right == null? finalLeft:_mergeLeftTree(finalLeft.right);
        }else{
            if(root.right == null){
                return root;
            }else{
                return _mergeLeftTree(root.right);
            }
        }
    }
}
