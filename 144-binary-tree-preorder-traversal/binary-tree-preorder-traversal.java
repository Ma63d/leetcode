# -*- coding:utf-8 -*-


# Given a binary tree, return the preorder traversal of its nodes' values.
#
#
# For example:
# Given binary tree {1,#,2,3},
#
#    1
#     \
#      2
#     /
#    3
#
#
#
# return [1,2,3].
#
#
# Note: Recursive solution is trivial, could you do it iteratively?


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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pointer = root;
        while(pointer != null || !st.isEmpty()){
            if(pointer != null){
                result.add(pointer.val);
                if(pointer.right != null) st.push(pointer.right);
                pointer = pointer.left;
            }else{
                pointer = st.pop();
            }
        }
        return result;
    }
}
