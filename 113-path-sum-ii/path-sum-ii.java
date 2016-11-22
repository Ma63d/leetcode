# -*- coding:utf-8 -*-


# Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
#
#
# For example:
# Given the below binary tree and sum = 22,
#
#               5
#              / \
#             4   8
#            /   / \
#           11  13  4
#          /  \    / \
#         7    2  5   1
#
#
#
# return
#
# [
#    [5,4,11,2],
#    [5,8,4,5]
# ]


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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.result = new ArrayList<List<Integer>>();
        if(root == null) return this.result;
        dfs(root,0,new ArrayList<Integer>(),sum);
        return this.result;
    }
    public void dfs(TreeNode root, int curSum, ArrayList<Integer> curResult,int target){
        curSum += root.val;
        curResult.add(root.val);
        if(root.left != null && root.right != null){
            dfs(root.left,curSum,curResult,target);
            dfs(root.right,curSum,curResult,target);    
        }else if(root.left == null && root.right == null){
            if(curSum == target){
                this.result.add(new ArrayList<Integer>(curResult));
            }
        }else if(root.left == null){
            dfs(root.right,curSum,curResult,target);
        }else{
            dfs(root.left,curSum,curResult,target);
        }
        curResult.remove(curResult.size()-1);
    }
}
