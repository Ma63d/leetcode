# -*- coding:utf-8 -*-


# Given a set of distinct integers, nums, return all possible subsets.
#
# Note: The solution set must not contain duplicate subsets.
#
#
# For example,
# If nums = [1,2,3], a solution is:
#
#
#
# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ]


public class Solution {
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<List<Integer>>();
        for(int i = 1;i < nums.length+1;i++){
            _solve(nums,0,i,new ArrayList<Integer>());
        }
        this.result.add(new ArrayList<Integer>());
        return this.result;
    }
    public void _solve(int[] nums,int start,int left,ArrayList<Integer> res ){
        for(int i = start;i<= nums.length - left;i++){
            res.add(nums[i]);
            if(left == 1){
                this.result.add(new ArrayList<Integer>(res));
            }else{
                _solve(nums,i+1,left-1,res);
            }
            res.remove(res.size()-1);
        }
    }
}
